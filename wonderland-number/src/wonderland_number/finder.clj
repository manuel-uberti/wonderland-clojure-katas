(ns wonderland-number.finder)

(defn same-digits? [x y]
  (= (set (str x)) (set (str y))))

(defn wonderland-number []
  (loop [n 100000]
    (let [d (* n 2)
          t (* n 3)
          q (* n 4)
          c (* n 5)
          s (* n 6)]
      (if (and (same-digits? n d)
               (same-digits? n t)
               (same-digits? n q)
               (same-digits? n c)
               (same-digits? n s))
        n
        (recur (inc n))))))
