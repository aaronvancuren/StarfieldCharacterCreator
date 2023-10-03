package model.test;

import model.Rank;
import model.Stat;

import java.util.LinkedList;

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
            LinkedList<Stat> statEffects = new LinkedList<>();
            Stat astrodynamicsStat = new Stat("Astrodynamics", 15, "Increases grav jump range.");
            statEffects.add(1, astrodynamicsStat);

            Rank rank = new Rank(1, 1, statEffects, "Make 5 grav jumps.", 0, 5, false);
            if (rank.getRank() != 1)
            {
                throw new Exception("Failed to save rank.");
            }

            LinkedList<Stat> rankStatEffects = rank.getStatEffects();
            if (!rankStatEffects.isEmpty())
            {
                if (rankStatEffects.contains(astrodynamicsStat))
                {
                    astrodynamicsStat = rankStatEffects.get(rankStatEffects.indexOf(astrodynamicsStat));
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
            for (Stat statEffect : rank.getStatEffects())
            {
                System.out.println("The " + statEffect.getName() + " is modified by " + statEffect.getEffect() + "%");
                System.out.println("Description: " + statEffect.getDescription());
            }

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
            LinkedList<Stat> statsEffected = rank.getStatEffects();
            for (Stat statEffect : statsEffected)
            {
                System.out.println("The " + statEffect.getName() + " is modified by " + statEffect.getEffect() + "%");
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed to show stats effected and their respective values. Error:" + e.getMessage());
            System.exit(e.hashCode());
        }
    }
}
