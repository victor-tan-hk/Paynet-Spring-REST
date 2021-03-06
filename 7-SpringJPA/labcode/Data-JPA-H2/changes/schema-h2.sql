;             
CREATE USER IF NOT EXISTS "SA" SALT 'b2ce90a209e03b6e' HASH 'a5ef103db1f3750ac0ef5a2c544321771ec39b58978828cb57c4fc64826142ac' ADMIN;         
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_128376E3_0F9E_46B1_AE12_AD87E2FCB584" START WITH 31 BELONGS_TO_TABLE;               
CREATE MEMORY TABLE "PUBLIC"."DEVELOPERS"(
    "ID" INTEGER DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_128376E3_0F9E_46B1_AE12_AD87E2FCB584" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_128376E3_0F9E_46B1_AE12_AD87E2FCB584",
    "AGE" INTEGER,
    "LANGUAGES" VARCHAR(255),
    "MARRIED" BOOLEAN,
    "NAME" VARCHAR(255)
);
ALTER TABLE "PUBLIC"."DEVELOPERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_8" PRIMARY KEY("ID");