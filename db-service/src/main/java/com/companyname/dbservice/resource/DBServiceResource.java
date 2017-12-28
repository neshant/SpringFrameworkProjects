package com.companyname.dbservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.companyname.dbservice.model.Person;
import com.companyname.dbservice.model.Quote;
import com.companyname.dbservice.model.Quotes;
import com.companyname.dbservice.repository.QuotesRepository;

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {

	private QuotesRepository quotesRepository;

	public DBServiceResource(QuotesRepository quotesRepository) {
		this.quotesRepository = quotesRepository;
	}

	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username) {

		return getQuotesByUserName(username);

	}

	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes quotes) {

		quotes.getQuotes().stream().map(quote -> new Quote(quotes.getUserName(), quote))
				.forEach(quote -> quotesRepository.save(quote));
		// .forEach(quote -> {
		// quotesRepository.save(new Quote(quotes.getUserName(),quote));
		// });
		return getQuotesByUserName(quotes.getUserName());

	}

	@DeleteMapping("/delete/{username}")
	public List<String> delete(@PathVariable("username") final String username) {
		List<Quote> quotes = quotesRepository.findByUserName(username);
		quotesRepository.delete(quotes);
		return getQuotesByUserName(username);

	}

	private List<String> getQuotesByUserName(final String username) {
		return quotesRepository.findByUserName(username).stream().map(Quote::getQuote)// method reference concise way

				// .map(quote -> { // this is normal way of calling method using notation
				// return quote.getQuote();
				// })
				.collect(Collectors.toList());
	}
}
