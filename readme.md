### Tasks for java 
mvn clean -DsuiteXmlFile=testng6.xml test - use this command to launch testng6.xml file

int actualMaximumPrice = Integer.parseInt(actualMaximumPriceAsString);
asserTrue(actualMaximumPrice >= 200,
            String.format("Expected price %d to be more that 200", actualMaximumPrice)
            );
            
private final String delimiter = System.getProperty("os.name").toLowerCase().contains("windows") ? "\\" : "/";
mvn clean -DsuiteXmlFile=testng11_1.xml -Dbrowser=chrome -Ddp=smoke test
mvn clean -DsuiteXmlFile=testng11_1.xml -Dbrowser=chrome -Ddp=regression test