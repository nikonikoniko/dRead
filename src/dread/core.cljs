(ns dread.core
  (:require [cljs.nodejs :as nodejs]
            [hello :as hello]
            [cowsay :refer [say]]
            [cljs.core.async
             :as a
             :refer [go put! chan <!]]))

;; (a/disable-reload!)

(nodejs/enable-util-print!)

(println (say (js-obj "text" "Hellooooooo good wooooorld")))

(set! *main-cli-fn* -main)

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
