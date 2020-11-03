FROM registry.access.redhat.com/ubi8/ubi-minimal
WORKDIR /work/
COPY target/com.example.bekt.demo.demoapplication /work/application
RUN chmod 775 /work
EXPOSE 8080
CMD ["./application"]