# shipping-service

Shipping microservice after splitting the monolith

## GCP

### Upload jar file to bucket
```
gsutil cp target/shipping-service-0.0.1-SNAPSHOT.jar \
    gs://sbt-train-bucket/shipping-service.jar
```

### Create compute instance for service
```
gcloud compute instances create shipping-service-instance \
--image-family debian-9 \
--image-project debian-cloud \
--machine-type g1-small \
--scopes "userinfo-email,cloud-platform" \
--metadata-from-file startup-script=instance-startup.sh \
--metadata BUCKET=sbt-train-bucket \
--zone europe-west2-a \
--tags shipping-service
```

### Stop instance to avoid extra costs
```
gcloud compute instances stop shipping-service-instance
```
