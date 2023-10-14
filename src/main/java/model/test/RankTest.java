package model.test;

import model.Rank;
import model.Stat;

import java.util.Objects;

public class RankTest
{
    public static void main(String[] args)
    {
        Rank rank = CreateRank();
        ShowRankDetails(rank);

        // Incremental Increase
        IncreaseChallengeProgress(rank, 0);
        System.out.println("Challenge progress: " + rank.getChallengeProgress());

        // Jump Increase
        IncreaseChallengeProgress(rank, 3);
        System.out.println("Challenge progress: " + rank.getChallengeProgress());

        // Complete Challenge
        IncreaseChallengeProgress(rank, 2);
        System.out.println("Challenge progress: " + rank.getChallengeProgress());
        if (rank.isNextRankAvailable())
        {
            System.out.println("Challenge completed.");
        }
        else
        {
            System.out.println("Failed to increase challenge progress.");
        }

        ShowStatsEffected(rank);
    }

    public static Rank CreateRank()
    {
        Rank rank = null;
        try
        {
            Stat stat = new Stat("Astrodynamics", 15, "Increases grav jump range.");
            rank = new Rank(1, 1, new Stat("Astrodynamics", 15, "Increases grav jump range."),
                                 "Make 5 grav jumps.", 5);
            if (rank.getRankId() != 1)
            {
                throw new Exception("Failed to create a rank with an id.");
            }

            if (rank.getRank() != 1)
            {
                throw new Exception("Failed to create a rank.");
            }

            Stat rankStat = rank.getStat();
            if (rankStat == null)
            {
                throw new Exception("Failed to add stat.");
            }

            var t = rankStat.getName();
            var s = stat.getName();
            if (!Objects.equals(rankStat.getName(), stat.getName()))
            {
                throw new Exception("Failed to add stat with correct name.");
            }

            if (stat.getEffect() != 15)
            {
                throw new Exception("Failed to add stat effect with correct value.");
            }

            if (!stat.getDescription().equals("Increases grav jump range."))
            {
                throw new Exception("Failed to add stat with correct description.");
            }

            if (!rank.getChallengeDescription().equals("Make 5 grav jumps."))
            {
                throw new Exception("Failed to add stat with correct challenge description.");
            }

            if (rank.getChallengeProgress() != 0)
            {
                throw new Exception("Failed to add stat with correct challenge progress.");
            }

            if (rank.getChallengeGoal() != 5)
            {
                throw new Exception("Failed to add stat with correct challenge goal.");
            }

            if (rank.isNextRankAvailable())
            {
                throw new Exception("Failed to add stat with correct default value for isNextRankAvailable.");
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed to create rank. Error: " + e.getMessage());
            System.exit(e.hashCode());
        }

        return rank;
    }

    public static void ShowRankDetails(Rank rank)
    {
        try
        {
            System.out.println("Current rank: " + rank.getRank());
            Stat stat = rank.getStat();
            System.out.println("The " + stat.getName() + " is modified by " + stat.getEffect() + "%");
            System.out.println("Description: " + stat.getDescription());
            System.out.println("Challenge: " + rank.getChallengeDescription());
            System.out.println("Challenge progress: " + rank.getChallengeProgress());
            System.out.println("Challenge goal: " + rank.getChallengeGoal());
            System.out.println("Next rank available: " + rank.isNextRankAvailable());
        }
        catch (Exception e)
        {
            System.out.println("Failed to show rank details. Error:" + e.getMessage());
            System.exit(e.hashCode());
        }
    }

    public static void IncreaseChallengeProgress(Rank rank, int progressAmount)
    {
        try
        {
            int currentChallengeProgress = rank.getChallengeProgress();
            if (progressAmount > 0)
            {
                rank.increaseChallengeProgress(progressAmount);
                if (rank.getChallengeProgress() != currentChallengeProgress + progressAmount)
                {
                    throw new Exception("Failed to increase the challenge progress by " + progressAmount);
                }
            }
            else
            {
                rank.increaseChallengeProgress();
                if (rank.getChallengeProgress() != currentChallengeProgress + 1)
                {
                    throw new Exception("Failed to add incremental increase to challenge progress.");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed to increase challenge progress. Error:" + e.getMessage());
            System.exit(e.hashCode());
        }
    }

    public static void ShowStatsEffected(Rank rank)
    {
        try
        {
            Stat stat = rank.getStat();
            System.out.println("The " + stat.getName() + " is modified by " + stat.getEffect() + "%");
        }
        catch (Exception e)
        {
            System.out.println("Failed to show stats effected and their respective values. Error:" + e.getMessage());
            System.exit(e.hashCode());
        }
    }
}
