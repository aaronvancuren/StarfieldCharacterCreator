package model.test;

import model.Rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
            Map<String, Double> statEffects = new HashMap<String, Double>();
            statEffects.put("Astrodynamics", 15.0);

            Map<String, String> statEffectDescriptions = new HashMap<String, String>();
            statEffectDescriptions.put("Astrodynamics", "Increases ship fuel.");

            Rank rank = new Rank(1, statEffects, statEffectDescriptions, "Make 5 grav jumps.", 5);
            if (rank.getRank() != 1)
            {
                throw new Exception("Failed to save rank.");
            }

            if (rank.getStatEffects().size() > 0)
            {
                if (rank.getStatEffects().containsKey("Astrodynamics"))
                {
                    if (rank.getStatEffects().get("Astrodynamics") != 15.0)
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

            if (!rank.getStatEffectDescription("Astrodynamics").equals("Increases ship fuel."))
            {
                throw new Exception("Failed to save stat effect description for Astrodynamics.");
            }

            if (!rank.getChallengeDescription().equals("Make 5 grav jumps."))
            {
                throw new Exception("Failed to save challenge description.");
            }

            if (rank.getChallengeGoal() != 5)
            {
                throw new Exception("Failed to save challenge goal.");
            }

            if (rank.getChallengeProgress() != 0)
            {
                throw new Exception("Failed to set challenge progress.");
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
            for (Map.Entry<String, Double> statEffect : rank.getStatEffects().entrySet())
            {
                System.out.println("The " + statEffect.getKey() + " is modified by " + statEffect.getValue() + "%");
                System.out.println("Description: " + rank.getStatEffectDescription(statEffect.getKey()));
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
            Set<String> statsEffected = rank.getStatsEffected();
            for (String statEffect : statsEffected)
            {
                double statEffectValue = rank.getStatEffectValue(statEffect);
                System.out.println("The " + statEffect + " is modified by " + statEffectValue + "%");
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed to show stats effected and their respective values. Error:" + e.getMessage());
            System.exit(e.hashCode());
        }
    }
}
