(ns culture.facts
  "Regional-culture catalog for London (Greater London / City of London) --
  local dishes, protected products, beverages, festivals and heritage sites,
  piggybacked onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"london"
   [{:culture/id "london.dish.pie-and-mash"
     :culture/name "Pie and mash"
     :culture/municipality "london"
     :culture/country "GBR"
     :culture/kind :dish
     :culture/summary "British working-class food originating in the docks of London, considered a Cockney classic."
     :culture/url "https://en.wikipedia.org/wiki/Pie_and_mash"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "london.dish.jellied-eels"
     :culture/name "Jellied eels"
     :culture/municipality "london"
     :culture/country "GBR"
     :culture/kind :dish
     :culture/summary "Traditional English dish of chopped eels boiled in spiced stock and served cold in the set jelly, originating in the 18th century primarily in the East End of London."
     :culture/url "https://en.wikipedia.org/wiki/Jellied_eels"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "london.dish.fish-and-chips"
     :culture/name "Fish and chips"
     :culture/municipality "london"
     :culture/country "GBR"
     :culture/kind :dish
     :culture/summary "Often considered the national dish of the United Kingdom; the first recorded combined fish-and-chip shop was opened by Joseph Malin in Bow, East London, circa 1860."
     :culture/url "https://en.wikipedia.org/wiki/Fish_and_chips"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "london.dish.chelsea-bun"
     :culture/name "Chelsea bun"
     :culture/municipality "london"
     :culture/country "GBR"
     :culture/kind :dish
     :culture/summary "Currant bun first baked in the 18th century at the Bun House in Chelsea, London, an establishment demolished in 1839."
     :culture/url "https://en.wikipedia.org/wiki/Chelsea_bun"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "london.beverage.porter"
     :culture/name "Porter"
     :culture/municipality "london"
     :culture/country "GBR"
     :culture/kind :beverage
     :culture/summary "Dark style of beer developed in London in the early 18th century, later adopted across many regions."
     :culture/url "https://en.wikipedia.org/wiki/Porter_(beer)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "london.craft.savile-row-tailoring"
     :culture/name "Savile Row bespoke tailoring"
     :culture/municipality "london"
     :culture/country "GBR"
     :culture/kind :craft
     :culture/summary "Savile Row, a street in Mayfair, central London, is known principally for its traditional bespoke tailoring for men."
     :culture/url "https://en.wikipedia.org/wiki/Savile_Row"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "london.festival.notting-hill-carnival"
     :culture/name "Notting Hill Carnival"
     :culture/municipality "london"
     :culture/country "GBR"
     :culture/kind :festival
     :culture/summary "Annual Caribbean carnival held over the August Bank Holiday weekend in the Notting Hill area of London, one of the world's largest street festivals."
     :culture/url "https://en.wikipedia.org/wiki/Notting_Hill_Carnival"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "london.heritage.tower-of-london"
     :culture/name "Tower of London"
     :culture/municipality "london"
     :culture/country "GBR"
     :culture/kind :heritage
     :culture/summary "Historic citadel and castle on the north bank of the River Thames in London, designated a UNESCO World Heritage Site in 1988."
     :culture/url "https://en.wikipedia.org/wiki/Tower_of_London"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-gbr-london culture catalog "
                 "(ADR-2607171400): " (count (get catalog "london"))
                 " London entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
