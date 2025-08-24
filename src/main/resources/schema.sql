DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS yoga_poses;

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE yoga_poses (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    benefits TEXT,
    difficulty VARCHAR(50),
    duration INT,
    image_url VARCHAR(255)
);
