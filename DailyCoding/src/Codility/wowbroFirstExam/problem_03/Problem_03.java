package codility.wowbroFirstExam.problem_03;

public class Problem_03 {

    public static int solution() {

        /*
        SELECT total.team_id,
                total.team_name,
                SUM(total.num_points) AS num_points
        FROM (
                SELECT  teams.team_id,
                CASE WHEN matches.host_goals > matches.guest_goals THEN 3
                WHEN matches.host_goals = matches.guest_goals THEN 1
                ELSE 0 END AS num_points,
                teams.team_name
                FROM matches matches RIGHT OUTER JOIN teams teams
                ON matches.host_team = teams.team_id
                UNION ALL
                SELECT teams.team_id,
                CASE WHEN matches.host_goals < matches.guest_goals THEN 3
                WHEN matches.host_goals = matches.guest_goals THEN 1
                ELSE 0 END AS num_points,
                teams.team_name
                FROM matches matches RIGHT OUTER JOIN teams teams
                ON matches.guest_team = teams.team_id ) total
        GROUP BY total.team_id, total.team_name
        ORDER BY num_points DESC, team_id ASC;
        */
        return -1;
    }
}
