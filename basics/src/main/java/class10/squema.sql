-- Create your schema using DBBrowser, IntelliJ database features or create it using JDBC statements.

CREATE TABLE `product` (
   `code`	TEXT NOT NULL,
   `name`	TEXT,
   `price`	REAL,
   `quantity`	INTEGER,
   PRIMARY KEY(`code`)
);

CREATE TABLE `sale` (
    `id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    `quantity`	INTEGER NOT NULL,
    `seller`	TEXT,
    `product`	TEXT,
    FOREIGN KEY(`product`) REFERENCES `product`(`code`)
);

