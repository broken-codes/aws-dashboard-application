package org.brokencodes.tutorials.ada.apis.beans.s3;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class S3BasicInformation {

    private String name;

    private String createdOn;

    private String owner;

}
