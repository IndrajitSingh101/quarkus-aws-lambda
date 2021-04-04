# CRYPTO TICKER lambda function

This project uses Quarkus, the Supersonic Subatomic Java Framework. It uses AWS API-GATEWAY REST lambda dependency.
API_KEY is required to fetch the CRYPTO currency data.Please get API key from nomics.
The format of the url fetch
crypto/getCryptoValue/BAT

command to run for spawning lambda function in local: sam local start-api --template target/sam.jvm.yaml

command used to deploy lambda function in AWS:  sam deploy -t target/sam.jvm.yaml -g

Note: mvn install or package is required to create target folder


