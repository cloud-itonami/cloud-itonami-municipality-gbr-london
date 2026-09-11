(ns ordinance.facts
  "Municipal-ordinance compliance catalog for London -- the THIRD
  municipality-level entry (see cloud-itonami-municipality-jpn-tokyo and
  -usa-washington-dc for the first two) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation).

  Every entry cites an OFFICIAL legislation.gov.uk 'ukla' (UK Local Acts)
  URL -- never fabricated. An ordinance not in this table has NO
  spec-basis, full stop; extend `catalog`, do not invent an id/url/number.
  london.gov.uk (the Greater London Authority's own site) returned HTTP
  403 to WebFetch, same failure mode as several other government portals
  in this family (e-Gov, fedlex.admin.ch, indiacode.nic.in) -- rather than
  fabricate a London Plan citation from search-snippet text alone, this
  catalog pivoted to London's OTHER real primary-source channel: the
  'London Local Authorities Act' series, which Parliament enacts
  specifically for London's local authorities and which legislation.gov.uk
  hosts as UK Local Acts (distinct in :kind from a Japanese 条例/reiki
  ordinance or a US municipal code -- these are Acts of Parliament with
  purely local territorial application, so `:kind :local-act` is used
  rather than reusing `:municipal-code`/`:ordinance`).

  Both entries below were directly WebFetch-verified against the live
  legislation.gov.uk page on 2026-07-15 (title, citation, Royal Assent
  date, and Part/Chapter subject headings all read back from the actual
  document, not guessed).")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"london"
   [{:ordinance/id "london.local-authorities-act-2007"
     :ordinance/title "London Local Authorities Act 2007"
     :ordinance/municipality "london"
     :ordinance/country "GBR"
     :ordinance/kind :local-act
     :ordinance/number "2007 c. ii"
     :ordinance/url "https://www.legislation.gov.uk/ukla/2007/2/enacted"
     :ordinance/url-provenance :official-legislation-gov-uk
     :ordinance/enacted-date "2007-07-19"
     :ordinance/retrieved-at "2026-07-15"
     :ordinance/topic #{:environment :licensing}}
    {:ordinance/id "london.local-authorities-act-2012"
     :ordinance/title "London Local Authorities Act 2012"
     :ordinance/municipality "london"
     :ordinance/country "GBR"
     :ordinance/kind :local-act
     :ordinance/number "2012 c. ii"
     :ordinance/url "https://www.legislation.gov.uk/ukla/2012/2/enacted"
     :ordinance/url-provenance :official-legislation-gov-uk
     :ordinance/enacted-date "2012-03-27"
     :ordinance/retrieved-at "2026-07-15"
     :ordinance/topic #{:street-trading :licensing}}]})

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
      :note (str "cloud-itonami-municipality-gbr-london Wave 0 (ADR-2607141700): "
                 (count (get catalog "london")) " London entries seeded with "
                 "an official legislation.gov.uk (UK Local Acts) citation. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
