/*
 * Copyright (C) 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.genomics.utils;

import static org.hamcrest.MatcherAssert.assertThat;

import com.google.cloud.genomics.utils.ShardUtils.SexChromosomeFilter;
import com.google.genomics.v1.StreamReadsRequest;
import com.google.genomics.v1.StreamVariantsRequest;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RunWith(JUnit4.class)
public class ShardUtilsITCase {

  @Test
  public void testGetVariantRequestsStringSexChromosomeFilterLongOfflineAuth() throws IOException, GeneralSecurityException {
    StreamVariantsRequest prototype = StreamVariantsRequest.newBuilder()
        .setVariantSetId(IntegrationTestHelper.PLATINUM_GENOMES_VARIANTSET)
        .setProjectId(IntegrationTestHelper.getTEST_PROJECT())
        .build();

    StreamVariantsRequest[] EXPECTED_RESULT_XY = {
        new Contig("chrX", 0L, 150000000L)
        .getStreamVariantsRequest(prototype),
        new Contig("chrX", 150000000L, 156231278L)
        .getStreamVariantsRequest(prototype),
        new Contig("chrY", 0L, 60032946L)
        .getStreamVariantsRequest(prototype)
    };

    StreamVariantsRequest[] EXPECTED_RESULT = {
        new Contig("chr1", 0L, 150000000L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr1", 150000000L, 250226910L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr10", 0L, 136466007L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr11", 0L, 135762137L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr12", 0L, 134049696L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr13", 0L, 115800144L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr14", 0L, 107857350L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr15", 0L, 103000009L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr16", 0L, 90760361L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr17", 0L, 81983044L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr18", 0L, 78776233L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr19", 0L, 59544813L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr2", 0L, 150000000L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr2", 150000000L, 243800708L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr20", 0L, 62993757L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr21", 0L, 48724643L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr22", 0L, 51891601L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr3", 0L, 150000000L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr3", 150000000L, 198316350L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr4", 0L, 150000000L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr4", 150000000L, 191970744L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr5", 0L, 150000000L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr5", 150000000L, 181054248L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr6", 0L, 150000000L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr6", 150000000L, 171796962L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr7", 0L, 150000000L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr7", 150000000L, 159737113L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr8", 0L, 147299246L)
        .getStreamVariantsRequest(prototype),
        new Contig("chr9", 0L, 142027288L)
        .getStreamVariantsRequest(prototype),
        new Contig("chrM", 0L, 1000001L)
        .getStreamVariantsRequest(prototype)
    };

    // These shards are "too big" to use in practice but for this test it keeps the
    // expected result from getting crazy long.
    assertThat(ShardUtils.getVariantRequests(prototype,
        SexChromosomeFilter.EXCLUDE_XY, 150000000L, IntegrationTestHelper.getAuthFromApiKey()),
        CoreMatchers.allOf(CoreMatchers.hasItems(EXPECTED_RESULT)));

    // Include sex chromosomes this time.
    assertThat(ShardUtils.getVariantRequests(prototype,
        SexChromosomeFilter.INCLUDE_XY, 150000000L, IntegrationTestHelper.getAuthFromApiKey()),
        CoreMatchers.allOf(CoreMatchers.hasItems(EXPECTED_RESULT),
            CoreMatchers.hasItems(EXPECTED_RESULT_XY)));
  }

  @Test
  public void testGetReadRequestsStringSexChromosomeFilterLongOfflineAuth() throws IOException, GeneralSecurityException {
    StreamReadsRequest prototype = StreamReadsRequest.newBuilder()
        .setReadGroupSetId(IntegrationTestHelper.PLATINUM_GENOMES_READGROUPSETS[0])
        .setProjectId(IntegrationTestHelper.getTEST_PROJECT())
        .build();

    StreamReadsRequest[] EXPECTED_RESULT_XY = {
        new Contig("chrX", 0L, 150000000L)
        .getStreamReadsRequest(prototype),
        new Contig("chrX", 150000000L, 155270560L)
        .getStreamReadsRequest(prototype),
        new Contig("chrY", 0L, 59373566L)
        .getStreamReadsRequest(prototype)
    };

    StreamReadsRequest[] EXPECTED_RESULT = {
        new Contig("chr1", 0L, 150000000L)
        .getStreamReadsRequest(prototype),
        new Contig("chr1", 150000000L, 249250621L)
        .getStreamReadsRequest(prototype),
        new Contig("chr10", 0L, 135534747L)
        .getStreamReadsRequest(prototype),
        new Contig("chr11", 0L, 135006516L)
        .getStreamReadsRequest(prototype),
        new Contig("chr12", 0L, 133851895L)
        .getStreamReadsRequest(prototype),
        new Contig("chr13", 0L, 115169878L)
        .getStreamReadsRequest(prototype),
        new Contig("chr14", 0L, 107349540L)
        .getStreamReadsRequest(prototype),
        new Contig("chr15", 0L, 102531392L)
        .getStreamReadsRequest(prototype),
        new Contig("chr16", 0L, 90354753L)
        .getStreamReadsRequest(prototype),
        new Contig("chr17", 0L, 81195210L)
        .getStreamReadsRequest(prototype),
        new Contig("chr18", 0L, 78077248L)
        .getStreamReadsRequest(prototype),
        new Contig("chr19", 0L,  59128983L)
        .getStreamReadsRequest(prototype),
        new Contig("chr2", 0L, 150000000L)
        .getStreamReadsRequest(prototype),
        new Contig("chr2", 150000000L, 243199373L)
        .getStreamReadsRequest(prototype),
        new Contig("chr20", 0L, 63025520L)
        .getStreamReadsRequest(prototype),
        new Contig("chr21", 0L, 48129895L)
        .getStreamReadsRequest(prototype),
        new Contig("chr22", 0L, 51304566L)
        .getStreamReadsRequest(prototype),
        new Contig("chr3", 0L, 150000000L)
        .getStreamReadsRequest(prototype),
        new Contig("chr3", 150000000L, 198022430L)
        .getStreamReadsRequest(prototype),
        new Contig("chr4", 0L, 150000000L)
        .getStreamReadsRequest(prototype),
        new Contig("chr4", 150000000L, 191154276L)
        .getStreamReadsRequest(prototype),
        new Contig("chr5", 0L, 150000000L)
        .getStreamReadsRequest(prototype),
        new Contig("chr5", 150000000L, 180915260L)
        .getStreamReadsRequest(prototype),
        new Contig("chr6", 0L, 150000000L)
        .getStreamReadsRequest(prototype),
        new Contig("chr6", 150000000L, 171115067L)
        .getStreamReadsRequest(prototype),
        new Contig("chr7", 0L, 150000000L)
        .getStreamReadsRequest(prototype),
        new Contig("chr7", 150000000L, 159138663L)
        .getStreamReadsRequest(prototype),
        new Contig("chr8", 0L, 146364022L)
        .getStreamReadsRequest(prototype),
        new Contig("chr9", 0L, 141213431L)
        .getStreamReadsRequest(prototype),
        new Contig("chrM", 0L, 16571L)
        .getStreamReadsRequest(prototype)
    };

    // These shards are "too big" to use in practice but for this test it keeps the
    // expected result from getting crazy long.
    assertThat(ShardUtils.getReadRequests(prototype,
        SexChromosomeFilter.EXCLUDE_XY, 150000000L, IntegrationTestHelper.getAuthFromApiKey()),
        CoreMatchers.allOf(CoreMatchers.hasItems(EXPECTED_RESULT)));

    // Include sex chromosomes this time.
    assertThat(ShardUtils.getReadRequests(prototype,
        SexChromosomeFilter.INCLUDE_XY, 150000000L, IntegrationTestHelper.getAuthFromApiKey()),
        CoreMatchers.allOf(CoreMatchers.hasItems(EXPECTED_RESULT),
            CoreMatchers.hasItems(EXPECTED_RESULT_XY)));
  }
}
