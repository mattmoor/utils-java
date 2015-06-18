// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/genomics/v1/references.proto

package com.google.genomics.v1;

public interface SearchReferenceSetsRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.genomics.v1.SearchReferenceSetsRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated string md5checksums = 1;</code>
   *
   * <pre>
   * If present, return references for which the `md5checksum`
   * matches. See `ReferenceSet.md5checksum` for details.
   * </pre>
   */
  com.google.protobuf.ProtocolStringList
      getMd5ChecksumsList();
  /**
   * <code>repeated string md5checksums = 1;</code>
   *
   * <pre>
   * If present, return references for which the `md5checksum`
   * matches. See `ReferenceSet.md5checksum` for details.
   * </pre>
   */
  int getMd5ChecksumsCount();
  /**
   * <code>repeated string md5checksums = 1;</code>
   *
   * <pre>
   * If present, return references for which the `md5checksum`
   * matches. See `ReferenceSet.md5checksum` for details.
   * </pre>
   */
  java.lang.String getMd5Checksums(int index);
  /**
   * <code>repeated string md5checksums = 1;</code>
   *
   * <pre>
   * If present, return references for which the `md5checksum`
   * matches. See `ReferenceSet.md5checksum` for details.
   * </pre>
   */
  com.google.protobuf.ByteString
      getMd5ChecksumsBytes(int index);

  /**
   * <code>repeated string accessions = 2;</code>
   *
   * <pre>
   * If present, return references for which the accession matches any of these
   * strings. Best to give a version number, for example
   * `GCF_000001405.26`. If only the main accession number is given
   * then all records with that main accession will be returned, whichever
   * version. Note that different versions will have different sequences.
   * </pre>
   */
  com.google.protobuf.ProtocolStringList
      getAccessionsList();
  /**
   * <code>repeated string accessions = 2;</code>
   *
   * <pre>
   * If present, return references for which the accession matches any of these
   * strings. Best to give a version number, for example
   * `GCF_000001405.26`. If only the main accession number is given
   * then all records with that main accession will be returned, whichever
   * version. Note that different versions will have different sequences.
   * </pre>
   */
  int getAccessionsCount();
  /**
   * <code>repeated string accessions = 2;</code>
   *
   * <pre>
   * If present, return references for which the accession matches any of these
   * strings. Best to give a version number, for example
   * `GCF_000001405.26`. If only the main accession number is given
   * then all records with that main accession will be returned, whichever
   * version. Note that different versions will have different sequences.
   * </pre>
   */
  java.lang.String getAccessions(int index);
  /**
   * <code>repeated string accessions = 2;</code>
   *
   * <pre>
   * If present, return references for which the accession matches any of these
   * strings. Best to give a version number, for example
   * `GCF_000001405.26`. If only the main accession number is given
   * then all records with that main accession will be returned, whichever
   * version. Note that different versions will have different sequences.
   * </pre>
   */
  com.google.protobuf.ByteString
      getAccessionsBytes(int index);

  /**
   * <code>optional string assembly_id = 3;</code>
   *
   * <pre>
   * If present, return reference sets for which a substring of their
   * `assemblyId` matches this string (case insensitive).
   * </pre>
   */
  java.lang.String getAssemblyId();
  /**
   * <code>optional string assembly_id = 3;</code>
   *
   * <pre>
   * If present, return reference sets for which a substring of their
   * `assemblyId` matches this string (case insensitive).
   * </pre>
   */
  com.google.protobuf.ByteString
      getAssemblyIdBytes();

  /**
   * <code>optional string page_token = 4;</code>
   *
   * <pre>
   * The continuation token, which is used to page through large result sets.
   * To get the next page of results, set this parameter to the value of
   * `nextPageToken` from the previous response.
   * </pre>
   */
  java.lang.String getPageToken();
  /**
   * <code>optional string page_token = 4;</code>
   *
   * <pre>
   * The continuation token, which is used to page through large result sets.
   * To get the next page of results, set this parameter to the value of
   * `nextPageToken` from the previous response.
   * </pre>
   */
  com.google.protobuf.ByteString
      getPageTokenBytes();

  /**
   * <code>optional int32 page_size = 5;</code>
   *
   * <pre>
   * Specifies the maximum number of results to return in a single page.
   * </pre>
   */
  int getPageSize();
}