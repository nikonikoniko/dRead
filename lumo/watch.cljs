(require '[lumo.build.api :as b])

(b/watch "src"
         {:main 'dread.core
          :output-to "watch/main.js"
          :output-dir "watch"
          :optimizations :none
          :verbose true
          :cache-analysis false
          :aot-cache false
          :optimize-constants false
          :recompile-dependents false
          :foreign-libs [{:file "src/js"
                          :module-type :es6}]
          :watch-fn (fn [] (println "Updated build"))
          :target :nodejs})
          ;; :npm-deps {:cowsay "1.4.0"}})
          ;; seems like it might not be necessary?
          ;; and lumo just automatically reads node_modules or package.json?
