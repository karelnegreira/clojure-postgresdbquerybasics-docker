(ns clojure-postgres-docker2.api
    (:require
      [compojure.core :refer :all]
      [compojure.route :as route]
      [clojure.pprint :as pp]
      [clojure.string :as str]
      [clojure.data.json :as cjson]
      [clojure-postgres-docker2.db :as db])
    (:gen-class))

(defn get-friends
      "Retrieve data from table"
      []
      (db/select :friends [:id :name :nickname :occupation]))

(defn add-friend
      "Add record to friend"
      [{name :name nickname :nickname occupation :occupation :as record}]
      (db/insert :friends record))