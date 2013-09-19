(ns clj-kafka.producer
  (:import [kafka.javaapi.producer Producer ProducerData]
           [kafka.producer ProducerConfig]
           [kafka.message Message])
  (:use [clj-kafka.core :only (as-properties)]))

(defn producer
  "Creates a Producer. m is the configuration
   serializer.class : default is kafka.serializer.DefaultEncoder
   zk.connect       : Zookeeper connection. e.g. localhost:2181 "
  [m]
  ^Producer (Producer. (ProducerConfig. (as-properties m))))

(defn message
  "Creates a message with the specified payload.
   payload : bytes for the message payload. e.g. (.getBytes \"hello, world\")"
  [#^bytes payload]
  (Message. payload))

(defn send-message
  "Sends a message.
   topic   : a string
   msgs    : a single message, or sequence of messages to send"
  [^Producer producer ^String topic msgs]
  (.send producer (ProducerData. topic msgs)))

(defn send-messages
  "Sends a sequence of messages.
   topic   : a string
   msgs    : a single message, or sequence of messages to send"
  [^Producer producer ^String topic ^java.util.List msgs]
  (.send producer (ProducerData. topic msgs)))

(defprotocol ToMessage
  "Protocol to be extended to convert types to encoded Message objects"
  (to-message [x] "Creates a Message instance"))

(extend-protocol ToMessage
  String
  (to-message [x] (message (.getBytes x))))
