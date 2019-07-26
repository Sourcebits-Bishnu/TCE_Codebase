package com.tce.content.web.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tce.common.web.TCEErrorResponse;
import com.tce.content.model.ContentBooksTata;
import com.tce.content.model.LessonMessageConstants;
import com.tce.content.service.ContentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/1/api/{version}")
public class ContentController {
	
	@Autowired
	private ContentService contentService;

	
	/**
	 * To get the book json and ebookpath If book json doesnt exist then convert
	 * book xml into json for the first time
	 * 
	 * @param bookId
	 * @return
	 */
	@GetMapping("/curriculum/book/{bookId}")
	@PreAuthorize("hasPermission('ClassEdge','VIEW')")
	public ResponseEntity<Object> getBookContent(@PathVariable("bookId") String bookId) throws Exception {
		ContentBooksTataResponse bookContent = null;

		// get book content and check whether converted to xml or not
		ContentBooksTata content = contentService.getBooks(bookId);
		if (null != content) {
			// get bookJson if not exists
			if (!content.isBookStatus()) {
				content = contentService.getBookJson(content);
				bookContent = new ContentBooksTataResponse(content.getBookId(), content.getTitle(), content.getBookJson());
			} else {
				bookContent = new ContentBooksTataResponse(content.getBookId(), content.getTitle(),
						content.getBookJson());
			}
			// get ebookPath if exists
			String eBookPath = contentService.getEBookPath(content);
			if (null != eBookPath) {
				bookContent.seteBookBasePath(eBookPath);
			}
			
			if (null != bookContent) {
				return new ResponseEntity<>(bookContent, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new TCEErrorResponse(LessonMessageConstants.NO_CONTENT.getCode(),
						LessonMessageConstants.NO_CONTENT.getMsg()), HttpStatus.NO_CONTENT);
			}
		} else {
			return new ResponseEntity<>(new TCEErrorResponse(LessonMessageConstants.NO_CONTENT.getCode(),
					LessonMessageConstants.NO_CONTENT.getMsg()), HttpStatus.NO_CONTENT);
		}

	}

}
