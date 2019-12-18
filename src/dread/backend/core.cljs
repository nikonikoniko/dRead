(ns dread.backend.core
  (:require [cljs.nodejs :as nodejs]
            ["../js/hello" :as hello]
            [cowsay :refer [say]]
            [cljs.core.async
             :refer [go put! chan <! >!]]))

(nodejs/enable-util-print!)

(defn saySomething []
  (println (say (clj->js {:text "Hellooooooo good wooooorld"})))
  (hello/sayHello)
  (def bigData (js->clj (.parse js/JSON "{\"haha\": \"hihu\"}") :keywordize-keys true))
  (println bigData)
  (println (:haha bigData))
  (println (get bigData :haha)))


(def warehouse-capacity 10)

(def warehouse-channel (chan warehouse-capacity))

(def stock-map {0 :shirt
                1 :pants
                2 :socks
                3 :shoes})

(defn- generate-random-items []
  (let [items (for [x (range warehouse-capacity)] (rand-int (count (keys stock-map))))]
    (map #(get stock-map %) items)))

(defn load-items-into-channel [items channel]
  (map #(>! channel %) items))

(load-items-into-channel (generate-random-items) warehouse-channel)

(println warehouse-channel)

(defn -main [& args]
  (hello/sayHello))

(set! *main-cli-fn* -main)
