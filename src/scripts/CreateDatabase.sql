create table `character`
(
    characterId          int auto_increment
        primary key,
    name                 varchar(255) charset utf8 not null,
    description          varchar(510) charset utf8 null,
    level                int                       not null,
    experience           int                       not null,
    experienceNeeded     int                       not null,
    availableSkillPoints int                       not null
);

create table skill
(
    skillId  int auto_increment
        primary key,
    name     varchar(255) charset utf8                                not null,
    category enum ('Physical', 'Social', 'Combat', 'Science', 'Tech') not null,
    tier     enum ('Novice', 'Advanced', 'Expert', 'Master')          not null,
    constraint skill_pk
        unique (name)
);

create table character_skill
(
    id                int auto_increment
        primary key,
    characterId       int        not null,
    skillId           int        not null,
    skillRank         int        not null,
    rankProgress      int        not null,
    nextRankAvailable tinyint(1) not null,
    constraint character_skill_pk
        unique (characterId, skillId),
    constraint character_skill_pk2
        unique (skillRank, skillId),
    constraint character_skill_character_characterId_fk
        foreign key (characterId) references `character` (characterId),
    constraint character_skill_skill_skillId_fk
        foreign key (skillId) references skill (skillId)
);

create table stat
(
    statId      int auto_increment
        primary key,
    name        varchar(255) charset utf8 not null,
    effect      int                       not null,
    description varchar(510) charset utf8 not null
);

create table character_stat
(
    id          int auto_increment
        primary key,
    characterId int not null,
    statId      int not null,
    constraint character_stat_pk
        unique (characterId, statId),
    constraint character_stat_character_characterId_fk
        foreign key (characterId) references `character` (characterId),
    constraint character_stat_stat_statId_fk
        foreign key (statId) references stat (statId)
);

create table `rank`
(
    rankId               int auto_increment
        primary key,
    `rank`               int                       not null,
    challengeDescription varchar(510) charset utf8 not null,
    challengeGoal        int                       not null,
    statId               int                       not null,
    skillId              int                       not null,
    constraint rank_pk
        unique (`rank`, skillId),
    constraint rank_skill_skillId_fk
        foreign key (skillId) references skill (skillId),
    constraint rank_stat_statId_fk
        foreign key (statId) references stat (statId)
);