package org.example;

/**
 * Hello world!
 *
 */

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

public class DeleteBucket {

    public static void main(String[] args) {

        String bucketName = "aws-emr-resources-603921576543-eu-west-1";
        /* Create S3 Client Object */
        AmazonS3 s3 = AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.EU_WEST_1)
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials("","")))
                .build();

        try {
            /* Get list of objects in a given bucket */
            ObjectListing objects = s3.listObjects(bucketName);
            /* Recursively delete all the objects inside given bucket */
            if(objects != null && objects.getObjectSummaries() != null) {
                while (true) {
                    for(S3ObjectSummary summary : objects.getObjectSummaries()) {
                        s3.deleteObject(bucketName, summary.getKey());
                    }

                    if (objects.isTruncated()) {
                        objects = s3.listNextBatchOfObjects(objects);
                    } else {
                        break;
                    }
                }
            }

            /* Get list of versions in a given bucket */
            VersionListing versions = s3.listVersions(new ListVersionsRequest().withBucketName(bucketName));

            /* Recursively delete all the versions inside given bucket */
            if(versions != null && versions.getVersionSummaries() != null) {
                while (true) {
                    for(S3VersionSummary summary : versions.getVersionSummaries()) {
                        s3.deleteObject(bucketName, summary.getKey());
                    }

                    if (versions.isTruncated()) {
                        versions = s3.listNextBatchOfVersions(versions);
                    } else {
                        break;
                    }
                }
            }

            /* Send Delete Bucket Request */
            s3.deleteBucket("streamsetstestireland");

        } catch (AmazonServiceException e) {

            System.out.println(e.getErrorMessage());

        } finally {

            if(s3 != null) {
                s3.shutdown();
            }
        }
    }
}