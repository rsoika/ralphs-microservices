FROM quay.io/wildfly/wildfly:26.0.0.Final
COPY ./target/*.war /opt/jboss/wildfly/standalone/deployments/
# Run with microprofiles
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "-c","standalone-full.xml"]
