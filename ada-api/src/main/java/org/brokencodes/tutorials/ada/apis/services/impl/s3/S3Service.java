package org.brokencodes.tutorials.ada.apis.services.impl.s3;

import com.amazonaws.services.s3.AmazonS3;
import org.brokencodes.tutorials.ada.apis.beans.s3.S3BasicInformation;
import org.brokencodes.tutorials.ada.apis.services.apis.s3.IS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@Service
public class S3Service implements IS3Service {

    @Autowired
    private AmazonS3 s3Client;

    @Override
    public Flux<S3BasicInformation> getS3BasicInformation() {
        Stream<S3BasicInformation> s3BucketStream = s3Client.listBuckets().stream()
                .map(bucket -> S3BasicInformation.builder()
                        .name(bucket.getName())
                        .createdOn(bucket.getCreationDate().toString())
                        .owner(bucket.getOwner().getDisplayName())
                        .build());
        return Flux.fromStream(s3BucketStream);
    }
}
