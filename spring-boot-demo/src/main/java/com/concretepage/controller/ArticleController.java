package com.concretepage.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.concretepage.entity.Article;
import com.concretepage.service.IArticleService;

@Controller
@RequestMapping("user")
public class ArticleController {
	//By using qualifier attribute you an explicitly define which dependency to inject
	//Here by default you can specify dependency by having the instance Name in BeanGeneratorName format only instance name will automatically determine 
	//the object being injected.
	@Qualifier("libraryService")
	@Autowired
	private IArticleService libraryService;
	@GetMapping("article/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable("id") Integer id) {
		Article article = libraryService.getArticleById(id);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
//	@GetMapping("articles")
//	public ResponseEntity<List<Article>> getAllArticles() {
//		List<Article> list = libraryService.getAllArticles();
//		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
//	}
	@GetMapping("articles")
	@ResponseBody
	public List<Article> getAllArticles() {
		List<Article> list = libraryService.getAllArticles();
		return list;
	}
	@PostMapping("article")
	public ResponseEntity<Void> addArticle(@RequestBody Article article, UriComponentsBuilder builder) {
        boolean flag = libraryService.addArticle(article);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("article")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		libraryService.updateArticle(article);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	@DeleteMapping("article/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		libraryService.deleteArticle(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 