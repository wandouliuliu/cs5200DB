DROP TABLE IF EXISTS `module`; 
CREATE TABLE IF NOT EXISTS `module`(
module VARCHAR(255) NOT NULL DEFAULT '',
PRIMARY KEY(module)
);
INSERT INTO module(module) VALUES('Project1');
INSERT INTO module(module) VALUES('Project2');
INSERT INTO module(module) VALUES('Assignment1');
INSERT INTO module(module) VALUES('Assignment2');
INSERT INTO module(module) VALUES('Quiz1');
INSERT INTO module(module) VALUES('Exam');
INSERT INTO module(module) VALUES('Logistics');

DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`(
`id` INT PRIMARY KEY REFERENCES `widget`(`id`),
`asked_by_user_id` INT DEFAULT NULL,
`text` VARCHAR(255) DEFAULT NULL,
`posted_on` DATE DEFAULT NULL,
`length` INT DEFAULT NULL,
`views` INT DEFAULT NULL,
`endorsed_by_instructor` BOOLEAN DEFAULT NULL,
`module` VARCHAR(20) DEFAULT '',
FOREIGN KEY(`asked_by_user_id`)
	REFERENCES `user`(`id`)
    ON DELETE CASCADE,
FOREIGN KEY(`module`)
	REFERENCES `module`(`module`)
    ON DELETE CASCADE
);

DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`(
`id` INT PRIMARY KEY REFERENCES `widget`(`id`),
`question's_id` INT DEFAULT NULL,
`posted_by_user_id` INT DEFAULT NULL,
`text` VARCHAR(255) DEFAULT NULL,
`posted_on` DATE DEFAULT NULL,
`correct_answer` BOOLEAN DEFAULT NULL,
`up_votes` INT DEFAULT NULL,
`down_votes` INT DEFAULT NULL,
FOREIGN KEY(`question's_id`)
	REFERENCES `question`(`id`)
    ON DELETE CASCADE,
FOREIGN KEY(`posted_by_user_id`) 
	REFERENCES `user`(`id`)
    ON DELETE CASCADE
);

# C

DROP PROCEDURE IF EXISTS getUnamsweredQuestions;

DELIMITER //

CREATE PROCEDURE getUnamsweredQuestions()
BEGIN

	SELECT q.`id`, q.`text` as `question text`, MAX(COUNT(a.`id`)) 
    FROM `question` q, `answer` a 
    WHERE a.`question's_id`=q.`id` AND a.`corrrect_answer` = FALSE 
    GROUP BY q.`module`;
    
    
END //

DELIMITER ;

DROP PROCEDURE IF EXISTS endorsedUsersForWeek;
DELIMITER //

CREATE PROCEDURE endorsedUsersForWeek(IN week_begin DATE, IN week_end DATE)
BEGIN

	SELECT p.`first_name` as `First Name`, p.`last_name` as `Last Name`, COUNT(a.`correct_answer`)
    FROM `person` p, `answer` a, `user` u
    WHERE a.`posred_on` > weed_begin AND a.`posted_on` < weed_end
		AND p.`id` = u.`id` AND p.`id` = a.`asked_by_user_id`
        AND a.`correct_answer` = TRUE
	GROUP BY(a.`asked_by_user_id`)
    LIMIT 5;
    
    
END //

DELIMITER ;
