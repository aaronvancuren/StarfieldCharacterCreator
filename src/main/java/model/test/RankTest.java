package model.test;

import model.Rank;
import model.Stat;

public class RankTest
{
    public static void main(String[] args)
    {
        // TODO: Will test with data from Excel file.
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
        try
        {
            Stat astrodynamicsStat = new Stat("Astrodynamics", 15, "Increases grav jump range.");

            Rank rank = new Rank(1, 1, new Stat("Astrodynamics", 15, "Increases grav jump range."),
                                 "Make 5 grav jumps.", 5);
            if (rank.getRank() != 1)
            {
                throw new Exception("Failed to save rank.");
            }

            Stat rankStat = rank.getStat();
            if (rankStat != null)
            {
                if (rankStat.equals(astrodynamicsStat))
                {
                    if (astrodynamicsStat.getEffect() != 15)
                    {
                        throw new Exception("Failed to add correct stat effect value.");
                    }
                }
                else
                {
                    throw new Exception("Failed to add stat effect Astrodynamics.");
                }
            }
            else
            {
                throw new Exception("Failed to add stat effects.");
            }

            if (!astrodynamicsStat.getDescription().equals("Increases grav jump range."))
            {
                throw new Exception("Failed to save stat effect description for Astrodynamics.");
            }

            if (!rank.getChallengeDescription().equals("Make 5 grav jumps."))
            {
                throw new Exception("Failed to save challenge description.");
            }

            if (rank.getChallengeProgress() != 0)
            {
                throw new Exception("Failed to set challenge progress.");
            }

            if (rank.getChallengeGoal() != 5)
            {
                throw new Exception("Failed to save challenge goal.");
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed to create rank. Error: " + e.getMessage());
            System.exit(e.hashCode());
        }

        return null;
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
