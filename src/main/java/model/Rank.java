package model;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;

public class Rank
{
    private static final Connection connection = MariaProvider.getConnection();
    private final int rankId;
    private final int rank;
    private final Stat stat;
    private final String challengeDescription;
    private int challengeProgress = 0;
    private final int challengeGoal;
    private boolean nextRankAvailable = false;

    public Rank(int rankId, int rank, Stat stat, String challengeDescription, int challengeGoal)
    {
        this.rankId = rankId;
        this.rank = rank;
        this.stat = stat;
        this.challengeDescription = challengeDescription;
        this.challengeGoal = challengeGoal;
    }

    public Rank(int rankId, int rank, Stat stat, String challengeDescription, int challengeProgress,
                int challengeGoal, boolean nextRankAvailable)
    {
        this.rankId = rankId;
        this.rank = rank;
        this.stat = stat;
        this.challengeDescription = challengeDescription;
        this.challengeProgress = challengeProgress;
        this.challengeGoal = challengeGoal;
        this.nextRankAvailable = nextRankAvailable;
    }

    public int getRankId()
    {
        return rankId;
    }

    public int getRank()
    {
        return rank;
    }

    public Stat getStat() {return stat;}

    public String getStatName()
    {
        return stat.getName();
    }

    public int getStatEffect()
    {
        return stat.getEffect();
    }

    public String getStatDescription()
    {
        return stat.getDescription();
    }

    public String getChallengeDescription()
    {
        return challengeDescription;
    }

    public int getChallengeProgress()
    {
        return challengeProgress;
    }

    public void increaseChallengeProgress()
    {
        challengeProgress++;
        nextRankAvailable = challengeProgress > challengeGoal;
    }

    public void increaseChallengeProgress(int progressAmount)
    {
        challengeProgress += progressAmount;
        nextRankAvailable = challengeProgress > challengeGoal;
    }

    public int getChallengeGoal()
    {
        return challengeGoal;
    }

    public boolean isNextRankAvailable()
    {
        return nextRankAvailable;
    }

    public TableView<Rank> getTableView()
    {
        TableView<Rank> tableView = new TableView<>();
        TableColumn<Rank, String> rank = new TableColumn<>("Rank");
        rank.setCellValueFactory(new PropertyValueFactory<>("rank"));
        TableColumn<Rank, String> challengeDescription = new TableColumn<>("Challenge Description");
        challengeDescription.setCellValueFactory(new PropertyValueFactory<>("challengeDescription"));
        TableColumn<Rank, Boolean> nextRankAvailable = new TableColumn<>("Next Rank Available");
        nextRankAvailable.setCellValueFactory(new PropertyValueFactory<>("nextRankAvailable"));
        tableView.getColumns().add(rank);
        tableView.getColumns().add(challengeDescription);
        tableView.getColumns().add(nextRankAvailable);
        tableView.getItems().addAll(this);
        return tableView;
    }
}
