(require '[lumo.build.api :as b])

(b/build "src"
         {:main 'read.core
          :output-to "out/main.js"
          :optimizations :advanced
          :target :nodejs
          :foreign-libs [{:file "src"
                          :module-type :es6}]
          :npm-deps {:cowsay "1.4.0"}})
