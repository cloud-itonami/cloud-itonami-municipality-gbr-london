# cloud-itonami-municipality-gbr-london

Municipal-ordinance compliance catalog for **London** — the THIRD
municipality-level entry alongside
[`cloud-itonami-municipality-jpn-tokyo`](https://github.com/cloud-itonami/cloud-itonami-municipality-jpn-tokyo)
and
[`cloud-itonami-municipality-usa-washington-dc`](https://github.com/cloud-itonami/cloud-itonami-municipality-usa-washington-dc).
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`).

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on the Greater London
Authority's behalf.

Coverage is reported honestly (see `ordinance.facts/coverage`): a
municipality not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/ordinance/facts.cljc` — the catalog, source of truth.
- `schema/ordinance.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

`london.gov.uk` (the Greater London Authority's own site, which was the
first choice for a London Plan citation) returned HTTP 403 to WebFetch —
the same failure mode hit by several other government portals in this
family. Rather than fabricate a citation from search-snippet text alone,
both entries here cite London's other real primary-source channel: the
**London Local Authorities Act** series, which Parliament enacts
specifically for London's local authorities and which
[legislation.gov.uk](https://www.legislation.gov.uk/) hosts as UK Local
Acts (`ukla`). Both were directly WebFetch-verified: the *London Local
Authorities Act 2007* (2007 c. ii, Royal Assent 2007-07-19, covering
public health/environment and licensing per its own Part 2/Part 3
headings) and the *London Local Authorities Act 2012* (2012 c. ii, Royal
Assent 2012-03-27, covering street trading and licensing amendments).

## Culture catalog

Alongside the ordinance catalog, this repo carries a **regional-culture
catalog** (ADR-2607171400, `cloud-itonami-municipality-culture-catalog`
in `com-junkawasaki/root`) — local dishes, protected products, beverages,
festivals and heritage sites for London:

- `src/culture/facts.cljc` — the catalog, source of truth.
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

Same provenance discipline as the ordinance catalog: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Act text itself
remains Crown copyright; this repo stores only citation metadata
(id/title/url/dates), not full text.
