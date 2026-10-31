(ns week7.tests)


(def teams ["Team A" "Team B" "Team C"])

(for [team1 teams
      team2 teams
      :when (not= team1 team2)]
  [team1 team2])

(for [team1 teams
      team2 teams
      :when (neg? (compare team1 team2))]
  [team1 team2])

