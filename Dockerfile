FROM payara/server-full
COPY target/atv-av-listatelefonica.war $DEPLOY_DIR
