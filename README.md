# places-api-demo

This Service lists two APIs: 
1. Find a place

    http://localhost:8080/places/<name_of_the_place_to_be_searched>
    
2. Search places nearby based on category

    http://localhost:8080/places?category=<category_to_be_searched>&location=<lat,lng>
    

Steps to run:
1. Get Google API key here: 
    https://developers.google.com/places/web-service/get-api-key
    
2. Run the application setting VM args as -Dgooglemaps.api.key=<YOUR_API_KEY>

The service is developed to accomodate any other Places api provider with minimal changes to the code.