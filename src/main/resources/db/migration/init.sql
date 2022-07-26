-- -----------------------------------------------------
-- Schema sport
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sport`;
USE `sport`;

-- -----------------------------------------------------
-- Table `sport`.`stadium`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport`.`stadium`
(
    `id`       INT         NOT NULL,
    `active`   TINYINT     NOT NULL DEFAULT 0,
    `name`     VARCHAR(64) NOT NULL,
    `dome`     TINYINT     NULL     DEFAULT 0,
    `city`     VARCHAR(64) NULL,
    `state`    VARCHAR(64) NULL,
    `geo_lat`  VARCHAR(64) NOT NULL,
    `geo_long` VARCHAR(64) NOT NULL,
    PRIMARY KEY (`id`)
);

-- -----------------------------------------------------
-- Table `sport`.`team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport`.`team`
(
    `id`         INT         NOT NULL,
    `name`       VARCHAR(64) NULL,
    `team_code`  VARCHAR(45) NULL,
    `stadium_id` INT         NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `football_team_to_stadium`
        FOREIGN KEY (`stadium_id`)
            REFERENCES `sport`.`stadium` (`id`)

);

-- -----------------------------------------------------
-- Table `sport`.`game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport`.`game`
(
    `id`              INT         NOT NULL,
    `season`          INT         NULL,
    `week`            INT         NULL,
    `status`          VARCHAR(45) NOT NULL,
    `date_time`       DATETIME    NULL,
    `away_team_id`    INT         NULL,
    `home_team_id`    INT         NULL,
    `away_team_score` INT         NULL,
    `home_team_score` INT         NULL,
    `stadium_id`      INT         NULL,
    `is_closed`       TINYINT     NULL DEFAULT 1,
    PRIMARY KEY (`id`),
    CONSTRAINT `football_game_to_home_team`
        FOREIGN KEY (`home_team_id`)
            REFERENCES `sport`.`team` (`id`),
    CONSTRAINT `football_game_to_away_team`
        FOREIGN KEY (`away_team_id`)
            REFERENCES `sport`.`team` (`id`),
    CONSTRAINT `football_game_to_stadium`
        FOREIGN KEY (`stadium_id`)
            REFERENCES `sport`.`stadium` (`id`)

);

-- -----------------------------------------------------
-- Table `sport`.`play`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport`.`play`
(
    `id`          INT          NOT NULL,
    `game_id`     INT          NULL,
    `date_time`   DATETIME     NULL,
    `description` VARCHAR(400) NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `play-by_play_to_football_game`
        FOREIGN KEY (`game_id`)
            REFERENCES `sport`.`game` (`id`)

);

-- -----------------------------------------------------
-- Table `sport`.`football_player_stat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport`.`football_player_stat`
(
    `id`                       INT         NOT NULL,
    `name`                     VARCHAR(64) NULL,
    `team_id`                  INT         NULL,
    `play_id`                  INT         NOT NULL,
    `position`                 VARCHAR(45) NULL,
    `passing_yards`            INT         NULL,
    `passing_touchdowns`       INT         NULL,
    `passing_interceptions`    INT         NULL,
    `rushing_yards`            INT         NULL,
    `rushing_touchdowns`       INT         NULL,
    `receiving_yards`          INT         NULL,
    `receiving_touchdowns`     INT         NULL,
    `punt_return_yards`        INT         NULL,
    `punt_return_touchdowns`   INT         NULL,
    `kick_return_yards`        INT         NULL,
    `kick_return_touchdowns`   INT         NULL,
    `punt_yards`               INT         NULL,
    `field_goal_attempted`     INT         NULL,
    `field_goal_made`          INT         NULL,
    `interception_yard_return` INT         NULL,
    `interception_touchdowns`  INT         NULL,
    `solo_tackles`             INT         NULL,
    `assisted_tackles`         INT         NULL,
    `sacks`                    INT         NULL,
    `passes_defended`          INT         NULL,
    `fumbles_recovered`        INT         NULL,
    `fumble_return_touchdown`  INT         NULL,
    `quarterback_hurries`      INT         NULL,
    `fumbles`                  INT         NULL,
    `fumbles_lost`             INT         NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `football_player_stat_to_team`
        FOREIGN KEY (`team_id`)
            REFERENCES `sport`.`team` (`id`),
    CONSTRAINT `football_player_stat_to_play`
        FOREIGN KEY (`play_id`)
            REFERENCES `sport`.`play` (`id`)

);

-- -----------------------------------------------------
-- Table `sport`.`weather_stat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport`.`weather_stat`
(
    `id`             INT         NOT NULL AUTO_INCREMENT,
    `play_id`        INT         NULL,
    `temperature`    VARCHAR(45) NULL,
    `feels_like`     VARCHAR(45) NULL,
    `wind_direction` VARCHAR(45) NULL,
    `wind_speed`     VARCHAR(45) NULL,
    `wind_gust`      VARCHAR(45) NULL,
    `conditions`     VARCHAR(64) NULL,
    `precipitation`  VARCHAR(45) NULL,
    `latitude`       VARCHAR(45) NULL,
    `longitude`      VARCHAR(45) NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `weather_stat_to_play`
        FOREIGN KEY (`play_id`)
            REFERENCES `sport`.`play` (`id`)
);

CREATE TABLE IF NOT EXISTS `sport`.`schedule`
(
    `game_id`      INT         NOT NULL,
    `stadium_id`   INT         NULL,
    `home_team_id` INT         NULL,
    `away_team_id` INT         NULL,
    `date_time`    DATETIME    NULL,
    `sport`        VARCHAR(45) NULL,
    PRIMARY KEY (`game_id`),
    CONSTRAINT `schedule_to_stadium`
        FOREIGN KEY (`stadium_id`)
            REFERENCES `sport`.`stadium` (`id`),
    CONSTRAINT `schedule_to_home_team`
        FOREIGN KEY (`home_team_id`)
            REFERENCES `sport`.`team` (`id`),
    CONSTRAINT `schedule_to_away_team`
        FOREIGN KEY (`away_team_id`)
            REFERENCES `sport`.`team` (`id`)
)