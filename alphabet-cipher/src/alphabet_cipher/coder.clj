(ns alphabet-cipher.coder)

(def alphabet "abcdefghijklmnopqrstuvwxyz")
(def alphabet-map {:a 0  :b 1  :c 2  :d 3
                   :e 4  :f 5  :g 6  :h 7
                   :i 8  :j 9 :k 10 :l 11
                   :m 12 :n 13 :o 14 :p 15
                   :q 16 :r 17 :s 18 :t 19
                   :u 20 :v 21 :w 22 :x 23
                   :y 24 :z 25})

;; Rotate a sequence n-times
(defn rotate [n s]
  (if (> n 0)
    (let [p (take n s)
          r (drop n s)
          l (count s)]
      (if (<= n l)
        (flatten (cons r p))
        (let [e (- n l)]
          (flatten (cons (drop e s) (take e s))))))
    (rotate (+ n (count s)) s)))

;; Repeat the keyword as many times as necessary
(defn repeat-keyword [k m]
  (let [s (seq k)
        l (count m)]
    (take l (flatten (repeat s)))))

(defn string-to-keys [s]
  (map keyword (map str (seq s))))

(defn get-encoded-char [x y]
  (str (nth (rotate (x alphabet-map) alphabet) (y alphabet-map))))

(defn encode [keyword message]
  (apply str (map get-encoded-char
                  (string-to-keys (repeat-keyword keyword message))
                  (string-to-keys (seq message)))))

(defn decode [keyword message]
  "decodeme")
