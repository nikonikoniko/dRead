(ns read.core
  (:require [cljs.nodejs :as nodejs]
            [js.hello :as hello]
            [cowsay :refer [say]]))

(nodejs/enable-util-print!)

(defn -main [& args]
  (hello/sayHello))

(println (say (js-obj "text" "Hellooooooo world")))

(set! *main-cli-fn* -main)
