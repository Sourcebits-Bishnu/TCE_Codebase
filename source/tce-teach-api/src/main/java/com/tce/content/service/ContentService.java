package com.tce.content.service;

import com.tce.content.model.ContentBooksTata;

public interface ContentService {
//	public CurriculumResponse gradeAndSubjectList(String orgId);
//
//	public List<PlaylistResponse> getVTPAssets(List<String> assetIds);
//
//	public List<PlaylistResponse> getTopicAssetDetails(List<String> ids);

	public ContentBooksTata getBooks(String bookId);

	public String getEBookPath(ContentBooksTata content);

	public ContentBooksTata getBookJson(ContentBooksTata content) throws Exception;

//	public RecentViewResponse getRecentViews(String userId, String organizationId);
//
//	public UserBookmark saveOrUpdateRecentViews(String organizationId, String userId,
//			UserBookmarkRequest userBookmarkRequest, boolean isUpdate);
//
//	public List<ContentQuestionData> getQuestionContents(List<String> questIds);
//
//	public QuestionJson saveQuestionXmlToJson(ContentQuestionData question);
//
//	public String getQuestionPath(String questionId);
//
//	public ContentTpTata getLPBytpId(String tpId);
//
//	public ContentTpTataXMLDetails getLpJson(ContentTpTata contentResponse);
//
//	public ContentTpTataXMLDetails getLpJsonXml(ContentTpTata contentResponse);

}
