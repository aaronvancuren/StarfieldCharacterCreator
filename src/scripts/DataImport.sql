/*Table character*/
INSERT INTO starfield.`character` (characterId, name, description, level, experience, experienceNeeded,
                                   availableSkillPoints)
VALUES (1, 'John Smith', 'Space Cowboy', 1, 0, 1000, 2);

/*Table character_skill*/
INSERT INTO starfield.character_skill (id, characterId, skillId, skillRank, rankProgress, nextRankAvailable)
VALUES (1, 1, 1, 1, 0, 0);

/*Table character_stat*/
INSERT INTO starfield.character_stat (id, characterId, statId)
VALUES (1, 1, 1);
INSERT INTO starfield.character_stat (id, characterId, statId)
VALUES (2, 1, 2);
INSERT INTO starfield.character_stat (id, characterId, statId)
VALUES (3, 1, 3);

/*Table rank*/
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (1, 1, 'Kill 20 enemies with an unarmed attack.', 20, 4, 1);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (2, 2, 'Kill 50 enemies with an unarmed attack.', 50, 5, 1);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (3, 3, 'Kill 100 enemies with an unarmed attack.', 100, 6, 1);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (4, 4, 'Skill Mastered', 0, 7, 1);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (5, 1, 'Use up all available Oxygen 20 times.', 20, 1, 2);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (6, 2, 'Use up all available Oxygen 50 times.', 50, 1, 2);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (7, 3, 'Use up all available Oxygen 100 times.', 100, 1, 2);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (8, 4, 'Skill Mastered', 0, 1, 2);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (9, 1, 'Perform 10 sneak attacks.', 10, 1, 3);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (10, 2, 'Perform 20 sneak attacks.', 20, 1, 3);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (11, 3, 'Perform 40 sneak attacks.', 40, 1, 3);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (12, 4, 'Skill Mastered', 0, 1, 3);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (13, 1, 'Sprint for 1000 meters while at 75% or more of your maximum load capacity.', 1000, 1, 4);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (14, 2, 'Sprint for 2500 meters while at 75% or more of your maximum load capacity.', 2500, 1, 4);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (15, 3, 'Sprint for 5000 meters while at 75% or more of your maximum load capacity.', 5000, 1, 4);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (16, 4, 'Skill Mastered', 0, 1, 4);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (17, 1, 'Heal 200 damage.', 200, 1, 5);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (18, 2, 'Heal 500 damage.', 500, 1, 5);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (19, 3, 'Heal 1,000 damage.', 1000, 1, 5);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (20, 4, 'Skill Mastered', 0, 1, 5);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (21, 1, 'Take 150 points of energy damage.', 150, 1, 6);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (22, 2, 'Take 350 points of energy damage.', 350, 1, 6);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (23, 3, 'Take 750 points of energy damage.', 750, 1, 6);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (24, 4, 'Skill Mastered', 0, 1, 6);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (25, 1, 'Take 100 environmental damage.', 100, 1, 7);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (26, 2, 'Take 250 environmental damage.', 250, 1, 7);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (27, 3, 'Take 500 environmental damage.', 500, 1, 7);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (28, 4, 'Skill Mastered', 0, 1, 7);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (29, 1, 'Take 100 fall damage.', 100, 1, 8);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (30, 2, 'Kill 5 enemies in Zero-G environments.', 5, 1, 8);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (31, 3, 'Kill 20 enemies in Zero-G environments.', 20, 1, 8);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (32, 4, 'Skill Mastered', 0, 1, 8);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (33, 1, 'Consume 10 food or drinks.', 10, 1, 9);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (34, 2, 'Consume 30 food or drinks.', 30, 1, 9);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (35, 3, 'Consume 75 food or drinks.', 75, 1, 9);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (36, 4, 'Skill Mastered', 0, 1, 9);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (37, 1, 'Take 250 points of physical damage.', 250, 1, 10);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (38, 2, 'Take 500 points of physical damage.', 500, 1, 10);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (39, 3, 'Take 1,000 points of physical damage.', 1000, 1, 10);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (40, 4, 'Skill Mastered', 0, 1, 10);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (41, 1, 'Recover from 5 injuries', 5, 1, 11);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (42, 2, 'Recover from 15 injuries', 15, 1, 11);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (43, 3, 'Recover from 30 injuries.', 30, 1, 11);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (44, 4, 'Skill Mastered', 0, 1, 11);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (45, 1, 'Recover from 5 infections', 5, 1, 12);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (46, 2, 'Recover from 15 infections', 15, 1, 12);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (47, 3, 'Recover from 30 infections', 30, 1, 12);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (48, 4, 'Skill Mastered', 0, 1, 12);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (49, 1, 'Deal 250 damage with unarmed attacks.', 250, 1, 13);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (50, 2, 'Disarm 10 enemies using melee or unarmed attacks.', 10, 1, 13);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (51, 3, 'Disarm 30 enemies using melee or unarmed attacks.', 30, 1, 13);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (52, 4, 'Skill Mastered', 0, 1, 13);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (53, 1, 'Perform 10 melee/unarmed sneak attacks.', 10, 1, 14);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (54, 2, 'Perform 30 melee/unarmed sneak attacks.', 30, 1, 14);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (55, 3, 'Perform 75 melee/unarmed sneak attacks.', 75, 1, 14);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (56, 4, 'Skill Mastered', 0, 1, 14);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (57, 1, 'Stun 10 enemies with an unarmed attack.', 10, 1, 15);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (58, 2, 'Stun 30 enemies with an unarmed attack.', 30, 1, 15);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (59, 3, 'Stun 75 enemies with an unarmed attack.', 75, 1, 15);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (60, 4, 'Skill Mastered', 0, 1, 15);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (61, 1, 'Fall below 25% health 3 times and fully heal', 3, 1, 16);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (62, 2, 'Fall below 25% health 8 times and fully heal', 8, 1, 16);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (63, 3, 'Fall below 25% health 15 times and fully heal', 15, 1, 16);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (64, 4, 'Skill Mastered', 0, 1, 16);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (65, 1, 'Buy or sell 25 unique items.', 25, 1, 17);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (66, 2, 'Buy or sell 75 unique items.', 75, 1, 17);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (67, 3, 'Buy or sell 150 unique items.', 150, 1, 17);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (68, 4, 'Skill Mastered', 0, 1, 17);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (69, 1, 'Create 5 food or drink items.', 5, 1, 18);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (70, 2, 'Create 25 food and drink items.', 25, 1, 18);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (71, 3, 'Create 50 food and drink items.', 50, 1, 18);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (72, 4, 'Skill Mastered', 0, 1, 18);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (73, 1, 'Succeed in 3 speech challenges.', 3, 1, 19);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (74, 2, 'Succeed in 5 speech challenges.', 5, 1, 19);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (75, 3, 'Succeed in 10 speech challenges.', 10, 1, 19);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (76, 4, 'Skill Mastered', 0, 1, 19);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (77, 1, 'Loot 25 containers.', 25, 1, 20);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (78, 2, 'Loot 75 containers.', 75, 1, 20);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (79, 3, 'Loot 150 containers.', 150, 1, 20);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (80, 4, 'Skill Mastered', 0, 1, 20);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (81, 1, 'Successfully pickpocket 5 times.', 5, 1, 21);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (82, 2, 'Successfully pickpocket 10 times.', 10, 1, 21);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (83, 3, 'Successfully pickpocket 20 times.', 20, 1, 21);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (84, 4, 'Skill Mastered', 0, 1, 21);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (85, 1, 'Convince 5 ships to surrender.', 5, 1, 22);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (86, 2, 'Convince 10 ships to surrender.', 10, 1, 22);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (87, 3, 'Convince 20 ships to surrender.', 20, 1, 22);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (88, 4, 'Skill Mastered', 0, 1, 22);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (89, 1, 'Successfully use Diplomacy on 5 different people.', 5, 1, 23);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (90, 2, 'Successfully use Diplomacy on 25 different people.', 25, 1, 23);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (91, 3, 'Successfully use Diplomacy on 50 different people.', 50, 1, 23);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (92, 4, 'Skill Mastered', 0, 1, 23);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (93, 1, 'Successfully intimidate 5 different people.', 5, 1, 24);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (94, 2, 'Successfully intimidate 25 different people.', 25, 1, 24);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (95, 3, 'Successfully intimidate 50 different people.', 50, 1, 24);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (96, 4, 'Skill Mastered', 0, 1, 24);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (97, 1, 'Bribe 3 times through persuasion.', 3, 1, 25);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (98, 2, 'Bribe 5 times through persuasion.', 5, 1, 25);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (99, 3, 'Bribe 10 times through persuasion.', 10, 1, 25);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (100, 4, 'Skill Mastered', 0, 1, 25);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (101, 1, 'Kill 20 enemies while not in command of a follower.', 20, 1, 26);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (102, 2, 'Kill 50 enemies while not in command of a follower.', 50, 1, 26);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (103, 3, 'Kill 100 enemies while not in command of a follower.', 100, 1, 26);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (104, 4, 'Skill Mastered', 0, 1, 26);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (105, 1, 'Successfully Instigate 5 different people.', 5, 1, 27);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (106, 2, 'Successfully Instigate 25 different people.', 25, 1, 27);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (107, 3, 'Successfully Instigate 50 different people.', 50, 1, 27);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (108, 4, 'Skill Mastered', 0, 1, 27);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (109, 1, 'Sprint 1000 meters with an active follower.', 1000, 1, 28);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (110, 2, 'Sprint 2,500 meters with an active follower.', 2500, 1, 28);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (111, 3, 'Sprint 5,000 meters with an active follower.', 5000, 1, 28);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (112, 4, 'Skill Mastered', 0, 1, 28);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (113, 1, 'Build cargo links on 6 different planets.', 6, 1, 29);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (114, 2, 'Construct 8 robots at outposts.', 8, 1, 29);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (115, 3, 'Construct 10 crew stations at outposts.', 10, 1, 29);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (116, 4, 'Skill Mastered', 0, 1, 29);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (117, 1, 'Successfully Manipulate 5 different people.', 5, 1, 30);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (118, 2, 'Successfully Manipulate 25 different people.', 25, 1, 30);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (119, 3, 'Successfully Manipulate 50 different people.', 50, 1, 30);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (120, 4, 'Skill Mastered', 0, 1, 30);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (121, 1, 'Destroy or board 5 ships with a crew of two or more.', 5, 1, 31);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (122, 2, 'Destroy or board 25 ships with a crew of four or more.', 25, 1, 31);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (123, 3, 'Destroy or board 50 ships with a crew of six or more.', 50, 1, 31);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (124, 4, 'Skill Mastered', 0, 1, 31);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (125, 1, 'Successfully use Pacify on 15 different aliens.', 15, 1, 32);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (126, 2, 'Successfully use Flee on 15 different aliens.', 15, 1, 32);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (127, 3, 'Successfully use Frenzy on 15 different aliens.', 15, 1, 32);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (128, 4, 'Skill Mastered', 0, 1, 32);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (129, 1, 'Kill 20 Enemies with a Ballistic Weapon.', 20, 1, 33);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (130, 2, 'Kill 50 Enemies with a Ballistic Weapon.', 50, 1, 33);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (131, 3, 'Kill 250 enemies with a Ballistic Weapon.', 250, 1, 33);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (132, 4, 'Skill Mastered', 0, 1, 33);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (133, 1, 'Kill 10 enemies with a melee weapon.', 10, 1, 34);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (134, 2, 'Kill 25 enemies with a melee weapon.', 25, 1, 34);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (135, 3, 'Kill 50 enemies with a melee weapon.', 50, 1, 34);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (136, 4, 'Kill 100 enemies with a melee weapon.', 100, 1, 34);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (137, 1, 'Kill 20 enemies with a laser weapon', 20, 1, 35);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (138, 2, 'Kill 50 enemies with a laser weapon', 50, 1, 35);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (139, 3, 'Kill 250 enemies with a laser weapon', 250, 1, 35);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (140, 4, 'Skill Mastered', 0, 1, 35);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (141, 1, 'Kill 20 enemies with a Pistol.', 20, 1, 36);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (142, 2, 'Kill 50 enemies with a Pistol.	', 50, 1, 36);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (143, 3, 'Kill 250 enemies with a Pistol.', 250, 1, 36);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (144, 4, 'Skill Mastered', 0, 1, 36);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (145, 1, 'Kill 20 enemies with a shotgun.', 20, 1, 37);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (146, 2, 'Kill 50 enemies with a shotgun.', 50, 1, 37);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (147, 3, 'Kill 250 enemies with a shotgun.', 250, 1, 37);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (148, 4, 'Skill Mastered', 0, 1, 37);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (149, 1, 'Kill 20 enemies with explosives', 20, 1, 38);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (150, 2, 'Kill 50 enemies with explosives', 50, 1, 38);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (151, 3, 'Kill 250 enemies with explosives', 250, 1, 38);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (152, 4, 'Skill Mastered', 0, 1, 38);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (153, 1, 'Kill 20 enemies with a heavy weapon', 20, 1, 39);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (154, 2, 'Kill 50 enemies with a heavy weapon', 50, 1, 39);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (155, 3, 'Kill 250 enemies with a heavy weapon', 250, 1, 39);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (156, 4, 'Skill Mastered', 0, 1, 39);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (157, 1, 'Deal 400 EM damage', 400, 1, 40);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (158, 2, 'Deal 800 EM damage', 800, 1, 40);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (159, 3, 'Deal 1200 EM damage', 1200, 1, 40);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (160, 4, 'Skill Mastered', 0, 1, 40);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (161, 1, 'Kill 20 enemies with a rifle', 20, 1, 41);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (162, 2, 'Kill 50 enemies with a rifle', 50, 1, 41);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (163, 3, 'Kill 250 enemies with a rifle', 250, 1, 41);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (164, 4, 'Skill Mastered', 0, 1, 41);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (165, 1, 'Deal 10 ranged critical hits', 10, 1, 42);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (166, 2, 'Deal 25 ranged critical hits', 25, 1, 42);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (167, 3, 'Deal 50 ranged critical hits', 50, 1, 42);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (168, 4, 'Skill Mastered', 0, 1, 42);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (169, 1, 'Kill 20 enemies with a particle beam weapon', 20, 1, 43);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (170, 2, 'Kill 50 enemies with a particle beam weapon', 50, 1, 43);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (171, 3, 'Kill 250 enemies with a particle beam weapon', 250, 1, 43);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (172, 4, 'Skill Mastered', 0, 1, 43);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (173, 1, 'Reload 30 empty magazines', 30, 1, 44);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (174, 2, 'Reload 50 empty magazines', 50, 1, 44);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (175, 3, 'Reload 100 empty magazines', 100, 1, 44);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (176, 4, 'Reload 150 empty magazines', 150, 1, 44);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (177, 1, 'Kill 20 enemies using a scoped weapon', 20, 1, 45);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (178, 2, 'Kill 50 enemies using a scoped weapon', 50, 1, 45);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (179, 3, 'Kill 250 enemies using a scoped weapon', 250, 1, 45);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (180, 4, 'Skill Mastered', 0, 1, 45);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (181, 1, 'Kill 50 enemies without aiming with a ranged weapon', 50, 1, 46);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (182, 2, 'Kill 75 enemies without aiming with a ranged weapon', 75, 1, 46);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (183, 3, 'Kill 125 enemies without aiming with a ranged weapon', 125, 1, 46);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (184, 4, 'Skill Mastered', 0, 1, 46);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (185, 1, 'Kill 20 enemies with a non-automatic weapon', 20, 1, 47);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (186, 2, 'Kill 50 enemies with a non-automatic weapon', 50, 1, 47);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (187, 3, 'Kill 250 enemies with a non-automatic weapon', 250, 1, 47);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (188, 4, 'Skill Mastered', 0, 1, 47);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (189, 1, 'Put 20 enemies into the bleedout state', 20, 1, 48);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (190, 2, 'Put 50 enemies into the bleedout state', 50, 1, 48);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (191, 3, 'Put 250 enemies into the bleedout state', 250, 1, 48);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (192, 4, 'Skill Mastered', 0, 1, 48);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (193, 1, 'Deal 50 ranged critical hits', 50, 1, 49);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (194, 2, 'Deal 150 ranged critical hits', 150, 1, 49);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (195, 3, 'Deal 250 ranged critical hits', 250, 1, 49);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (196, 4, 'Skill Mastered', 0, 1, 49);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (197, 1, 'Make 5 grav jumps', 5, 1, 50);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (198, 2, 'Make 10 grav jumps', 10, 1, 50);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (199, 3, 'Make 15 grav jumps', 15, 1, 50);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (200, 4, 'Skill Mastered', 0, 1, 50);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (201, 1, 'Harvest inorganic resources from 20 sources', 20, 1, 51);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (202, 2, 'Harvest inorganic resources from 50 sources', 50, 1, 51);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (203, 3, 'Harvest inorganic resources from 100 sources', 100, 1, 51);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (204, 4, 'Skill Mastered', 0, 1, 51);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (205, 1, 'Use healing items 20 times while wounded', 20, 1, 52);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (206, 2, 'Use healing items 50 times while wounded', 50, 1, 52);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (207, 3, 'Use healing items 100 times while wounded', 100, 1, 52);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (208, 4, 'Skill Mastered', 0, 1, 52);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (209, 1, 'Craft 5 unique food, drinks, drugs, weapon mods, or equipment mods.', 5, 1, 53);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (210, 2, 'Craft 10 unique food, drinks, drugs, weapon mods, or equipment mods.', 10, 1, 53);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (211, 3, 'Craft 15 unique food, drinks, drugs, weapon mods, or equipment mods.', 15, 1, 53);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (212, 4, 'Skill Mastered', 0, 1, 53);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (213, 1, 'Use the hand scanner to scan 10 unique resources', 10, 1, 54);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (214, 2, 'Use the hand scanner to scan 25 unique resources', 25, 1, 54);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (215, 3, 'Use the hand scanner to scan 50 unique resources', 50, 1, 54);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (216, 4, 'Skill Mastered', 0, 1, 54);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (217, 1, 'Harvest organic resources from 20 sources', 20, 1, 55);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (218, 2, 'Harvest organic resources from 50 sources', 50, 1, 55);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (219, 3, 'Harvest organic resources from 100 sources', 100, 1, 55);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (220, 4, 'Skill Mastered', 0, 1, 55);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (221, 1, 'Scan 5 planets or moons.', 5, 1, 56);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (222, 2, 'Scan 15 planets or moons.', 15, 1, 56);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (223, 3, 'Scan 30 planets or moons.', 30, 1, 56);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (224, 4, 'Skill Mastered', 0, 1, 56);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (225, 1, 'Craft 5 spacesuit', 5, 1, 57);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (226, 2, 'Craft 15 spacesuit', 15, 1, 57);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (227, 3, 'Craft 30 spacesuit', 30, 1, 57);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (228, 4, 'Skill Mastered', 0, 1, 57);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (229, 1, 'Craft 5 weapon mods', 5, 1, 58);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (230, 2, 'Craft 15 weapon mods', 15, 1, 58);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (231, 3, 'Craft 30 weapon mods', 30, 1, 58);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (232, 4, 'Skill Mastered', 0, 1, 58);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (233, 1, 'Harvest organic resources from 20 creatures', 20, 1, 59);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (234, 2, 'Harvest organic resources from 50 creatures', 50, 1, 59);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (235, 3, 'Harvest organic resources from 100 creatures', 100, 1, 59);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (236, 4, 'Skill Mastered', 0, 1, 59);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (237, 1, 'Scan 10 unique planets or moons.', 10, 1, 60);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (238, 2, 'Scan 25 unique planets or moons.', 25, 1, 60);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (239, 3, 'Scan 50 unique planets or moons.', 50, 1, 60);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (240, 4, 'Skill Mastered', 0, 1, 60);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (241, 1, 'Create 10 chems.', 10, 1, 61);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (242, 2, 'Create 25 chems.', 25, 1, 61);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (243, 3, 'Create 50 chems.', 50, 1, 61);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (244, 4, 'Skill Mastered', 0, 1, 61);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (245, 1, 'Build 10 different outpost modules', 10, 1, 62);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (246, 2, 'Build 25 different outpost modules', 25, 1, 62);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (247, 3, 'Build 50 different outpost modules', 50, 1, 62);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (248, 4, 'Skill Mastered', 0, 1, 62);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (249, 1, 'Destroy 5 ships', 5, 1, 63);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (250, 2, 'Destroy 15 ships', 15, 1, 63);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (251, 3, 'Destroy 30 ships', 30, 1, 63);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (252, 4, 'Skill Mastered', 0, 1, 63);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (253, 1, 'Build habitable outposts on 3 different planets', 3, 1, 64);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (254, 2, 'Build habitable outposts on 7 different planets', 7, 1, 64);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (255, 3, 'Build habitable outposts on 15 different planets', 15, 1, 64);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (256, 4, 'Skill Mastered', 0, 1, 64);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (257, 1, 'Craft 10 common or uncommon manufactured components', 10, 1, 65);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (258, 2, 'Craft 10 rare manufactured components', 10, 1, 65);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (259, 3, 'Craft 10 exotic manufactured components', 10, 1, 65);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (260, 4, 'Skill Mastered', 0, 1, 65);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (261, 1, 'Deal 1000 damage to enemy ships with ballistic weapons.', 1000, 1, 66);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (262, 2, 'Deal 2500 damage to enemy ships with ballistic weapons.', 2500, 1, 66);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (263, 3, 'Deal 5000 damage to enemy ships with ballistic weapons.', 5000, 1, 66);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (264, 4, 'Skill Mastered', 0, 1, 66);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (265, 1, 'Boost jump 10 times while in combat.', 10, 1, 67);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (266, 2, 'Boost jump 25 times while in combat.', 25, 1, 67);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (267, 3, 'Boost jump 50 times while in combat.', 50, 1, 67);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (268, 4, 'Skill Mastered', 0, 1, 67);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (269, 1, 'Destroy 5 ships.', 5, 1, 68);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (270, 2, 'Destroy 15 ships.', 15, 1, 68);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (271, 3, 'Destroy 30 ships.', 30, 1, 68);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (272, 4, 'Skill Mastered', 0, 1, 68);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (273, 1, 'Pick 5 locks.', 5, 1, 69);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (274, 2, 'Pick 15 locks.', 15, 1, 69);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (275, 3, 'Pick 30 locks.', 30, 1, 69);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (276, 4, 'Skill Mastered', 0, 1, 69);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (277, 1, 'Destroy 5 enemy ships while in targeting mode.', 5, 1, 70);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (278, 2, 'Destroy 15 enemy ships while in targeting mode.', 15, 1, 70);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (279, 3, 'Destroy 30 enemy ships while in targeting mode.', 30, 1, 70);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (280, 4, 'Skill Mastered', 0, 1, 70);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (281, 1, 'Deal 1000 damage to enemy ships with energy weapons.', 1000, 1, 71);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (282, 2, 'Deal 2500 damage to enemy ships with energy weapons.', 2500, 1, 71);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (283, 3, 'Deal 5000 damage to enemy ships with energy weapons.', 5000, 1, 71);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (284, 4, 'Skill Mastered', 0, 1, 71);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (285, 1, 'Boost 5 times with your spaceship while in combat.', 5, 1, 72);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (286, 2, 'Boost 15 times with your spaceship while in combat.', 15, 1, 72);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (287, 3, 'Boost 30 times with your spaceship while in combat.', 30, 1, 72);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (288, 4, 'Skill Mastered', 0, 1, 72);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (289, 1, 'Make 10 grav jumps with 75% or more of maximum cargo capacity', 10, 1, 73);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (290, 2, 'Make 25 grav jumps with 75% or more of maximum cargo capacity', 25, 1, 73);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (291, 3, 'Make 50 grav jumps with 75% or more of maximum cargo capacity', 50, 1, 73);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (292, 4, 'Skill Mastered', 0, 1, 73);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (293, 1, 'Take 150 shield damage.', 150, 1, 74);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (294, 2, 'Take 350 shield damage.', 350, 1, 74);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (295, 3, 'Take 750 shield damage.', 750, 1, 74);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (296, 4, 'Skill Mastered', 0, 1, 74);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (297, 1, 'Deal 1000 damage to enemy ships with missile weapons', 1000, 1, 75);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (298, 2, 'Deal 2500 damage to enemy ships with missile weapons', 2500, 1, 75);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (299, 3, 'Deal 5000 damage to enemy ships with missile weapons', 5000, 1, 75);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (300, 4, 'Skill Mastered', 0, 1, 75);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (301, 1, 'Deal 1000 damage to enemy ships with particle beam weapons', 1000, 1, 76);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (302, 2, 'Deal 2500 damage to enemy ships with particle beam weapons', 2500, 1, 76);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (303, 3, 'Deal 5000 damage to enemy ships with particle beam weapons', 5000, 1, 76);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (304, 4, 'Skill Mastered', 0, 1, 76);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (305, 1, 'Destroy 5 robots.', 5, 1, 77);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (306, 2, 'Destroy 15 robots.', 15, 1, 77);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (307, 3, 'Destroy 30 robots.', 30, 1, 77);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (308, 4, 'Skill Mastered', 0, 1, 77);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (309, 1, 'Install 5 unique ship modules.', 5, 1, 78);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (310, 2, 'Install 15 unique ship modules.', 15, 1, 78);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (311, 3, 'Install 30 unique ship modules.', 30, 1, 78);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (312, 4, 'Skill Mastered', 0, 1, 78);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (313, 1, 'Use 5 ship repair kits.', 5, 1, 79);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (314, 2, 'Use 15 ship repair kits.', 15, 1, 79);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (315, 3, 'Use 30 ship repair kits.', 30, 1, 79);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (316, 4, 'Skill Mastered', 0, 1, 79);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (317, 1, 'Deal 1000 damage to enemy ships with automated turret weapons.', 1000, 1, 80);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (318, 2, 'Deal 2500 damage to enemy ships with automated turret weapons.', 2500, 1, 80);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (319, 3, 'Deal 5000 damage to enemy ships with automated turret weapons.', 5000, 1, 80);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (320, 4, 'Skill Mastered', 0, 1, 80);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (321, 1, 'Deal 200 damage to enemies using the boost pack', 200, 1, 81);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (322, 2, 'Deal 350 damage to enemies using the boost pack.', 350, 1, 81);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (323, 3, 'Deal 500 damage to enemies using the boost pack.', 500, 1, 81);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (324, 4, 'Skill Mastered', 0, 1, 81);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (325, 1, 'Deal 1000 damage to enemy ships with EM weapons', 1000, 1, 82);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (326, 2, 'Deal 2500 damage to enemy ships with EM weapons', 2500, 1, 82);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (327, 3, 'Deal 5000 damage to enemy ships with EM weapons', 5000, 1, 82);
INSERT INTO starfield.`rank` (rankId, `rank`, challengeDescription, challengeGoal, statId, skillId)
VALUES (328, 4, 'Skill Mastered', 0, 1, 82);

/*Table skill*/
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (1, 'Boxing', 'Physical', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (2, 'Fitness', 'Physical', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (3, 'Stealth', 'Physical', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (4, 'Weight Lifting', 'Physical', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (5, 'Wellness', 'Physical', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (6, 'Energy Weapon Dissipation', 'Physical', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (7, 'Environmental Conditioning', 'Physical', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (8, 'Gymnastics', 'Physical', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (9, 'Nutrition', 'Physical', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (10, 'Pain Tolerance', 'Physical', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (11, 'Cellular Regeneration', 'Physical', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (12, 'Decontamination', 'Physical', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (13, 'Martial Arts', 'Physical', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (14, 'Concealment', 'Physical', 'Master');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (15, 'Neurostrikes', 'Physical', 'Master');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (16, 'Rejuvenation', 'Physical', 'Master');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (17, 'Commerce', 'Social', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (18, 'Gastronomy', 'Social', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (19, 'Persuasion', 'Social', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (20, 'Scavenging', 'Social', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (21, 'Theft', 'Social', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (22, 'Deception', 'Social', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (23, 'Diplomacy', 'Social', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (24, 'Intimidation', 'Social', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (25, 'Negotiation', 'Social', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (26, 'Isolation', 'Social', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (27, 'Instigation', 'Social', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (28, 'Leadership', 'Social', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (29, 'Outpost Management', 'Social', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (30, 'Manipulation', 'Social', 'Master');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (31, 'Ship Command', 'Social', 'Master');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (32, 'Xenosociology', 'Social', 'Master');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (33, 'Ballistics', 'Combat', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (34, 'Dueling', 'Combat', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (35, 'Lasers', 'Combat', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (36, 'Pistol Certification', 'Combat', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (37, 'Shotgun Certification', 'Combat', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (38, 'Demolitions', 'Combat', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (39, 'Heavy Weapon Certification', 'Combat', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (40, 'Incapacitation', 'Combat', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (41, 'Rifle Certification', 'Combat', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (42, 'Marksmanship', 'Combat', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (43, 'Particle Beams', 'Combat', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (44, 'Rapid Reloading', 'Combat', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (45, 'Sniper Certification', 'Combat', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (46, 'Targeting', 'Combat', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (47, 'Armor Penetration', 'Combat', 'Master');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (48, 'Crippling', 'Combat', 'Master');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (49, 'Sharpshooting', 'Combat', 'Master');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (50, 'Astrodynamics', 'Science', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (51, 'Geology', 'Science', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (52, 'Medicine', 'Science', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (53, 'Research Methods', 'Science', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (54, 'Surveying', 'Science', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (55, 'Botany', 'Science', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (56, 'Scanning', 'Science', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (57, 'Spacesuit Design', 'Science', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (58, 'Weapon Engineering', 'Science', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (59, 'Zoology', 'Science', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (60, 'Astrophysics', 'Science', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (61, 'Chemistry', 'Science', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (62, 'Outpost Engineering', 'Science', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (63, 'Aneutronic Fusion', 'Science', 'Master');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (64, 'Planetary Habitation', 'Science', 'Master');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (65, 'Special Projects', 'Science', 'Master');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (66, 'Ballistic Weapon Systems', 'Tech', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (67, 'Boost Pack Training', 'Tech', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (68, 'Piloting', 'Tech', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (69, 'Security', 'Tech', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (70, 'Targeting Control System', 'Tech', 'Novice');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (71, 'Energy Weapon Systems', 'Tech', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (72, 'Engine Systems', 'Tech', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (73, 'Payloads', 'Tech', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (74, 'Shield Systems', 'Tech', 'Advanced');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (75, 'Missile Weapon Systems', 'Tech', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (76, 'Particle Beam Weapon Systems', 'Tech', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (77, 'Robotics', 'Tech', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (78, 'Starship Design', 'Tech', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (79, 'Starship Engineering', 'Tech', 'Expert');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (80, 'Automated Weapon Systems', 'Tech', 'Master');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (81, 'Boost Assault Training', 'Tech', 'Master');
INSERT INTO starfield.skill (skillId, name, category, tier)
VALUES (82, 'EM Weapon Systems', 'Tech', 'Master');

/*Table stat*/
INSERT INTO starfield.stat (statId, name, effect, description)
VALUES (1, 'health', 100, '`Characters` health hit points.');
INSERT INTO starfield.stat (statId, name, effect, description)
VALUES (2, 'oxygen', 100, '`Characters` oxygen hit points.');
INSERT INTO starfield.stat (statId, name, effect, description)
VALUES (3, 'armor', 100, '`Characters` armor hit points.');
INSERT INTO starfield.stat (statId, name, effect, description)
VALUES (4, 'unarmed attack', 25, 'Unarmed attacks do 25% more damage.');
INSERT INTO starfield.stat (statId, name, effect, description)
VALUES (5, 'unarmed attack', 50, 'Unarmed attacks do 50% more damage.');
INSERT INTO starfield.stat (statId, name, effect, description)
VALUES (6, 'unarmed attack', 75, 'Unarmed attacks do 75% more damage.');
INSERT INTO starfield.stat (statId, name, effect, description)
VALUES (7, 'unarmed attack', 100, 'Unarmed attacks do 100% more damage.');
