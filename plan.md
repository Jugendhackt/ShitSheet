#PLAN

##plug-in does:
1. open stackoverflow - article about your problem
2. click "save"
3. scraping the data we need and send to shit-sheet-file and merge

##plug in functions:
- we use artoo --> scrape
- saveso is a function which scrapes title, code, date (what u want) and save in plugin (localStorage as a .sqlite file)
- loadso is a fuction which shows us the plugin data

##Shit-Sheet-programm does:
- generate cheat-sheet by analysing browser hsitory and most often used stackoverflow articles
- scrapes the data we need

- merge plugin-data to this localdata

- creates the SHit-Sheet we need (from both sources)

##Shit-Sheet-programm functions:
- history is saved .sql file
- use extra propgramm to open most visited articles --> scrape
- fill in the localdata

- transforms .sqlite data to format like localdata
- merges

