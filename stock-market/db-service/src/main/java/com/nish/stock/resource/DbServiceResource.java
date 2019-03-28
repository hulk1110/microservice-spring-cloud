package com.nish.stock.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nish.stock.model.Quote;
import com.nish.stock.model.Quotes;
import com.nish.stock.repository.QuotesRepository;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

	 private QuotesRepository quotesRepository;

	    public DbServiceResource(QuotesRepository quotesRepository) {
	        this.quotesRepository = quotesRepository;
	    }

	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username) {
		return getQuotesByUserName(username);

	}
	
	
	private List<String> getQuotesByUserName(String username) {
		// TODO Auto-generated method stub
		return quotesRepository.findByUserName(username).stream().map(quote -> {
			return quote.getQuote();
		}).collect(Collectors.toList());
	}


	@PostMapping("/add")
	public List<String> add (@RequestBody final Quotes quotes){
		
		quotes.getQuotes()
		.stream()
		.map(quote-> new Quote(quotes.getUserName(),quote))
		.forEach(quote->{
		quotesRepository.save(quote);
		}
		);
		
		return getQuotesByUserName(quotes.getUserName());
		
	}
	
	
	@PostMapping("/delete/{username}")
	public List<String> delete (@PathVariable("username") final String username ){
		
		List<Quote> quotes = quotesRepository.findByUserName(username);
        quotesRepository.delete(quotes);

        return getQuotesByUserName(username);
	}
	
	
}
