(require '[lumo.build.api :as b])

(b/watch "src"
         {:main 'read.core
          :output-to "watch/main.js"
          :verbose true
          :foreign-libs [{:file "src"
                          :module-type :es6}]
          :watch-fn (fn [] (println "Updated build"))
          :target :nodejs})
          ;; :npm-deps {:cowsay "1.4.0"}})
          ;; seems like it might not be necessary?
          ;; and lumo just automatically reads node_modules or package.json?
