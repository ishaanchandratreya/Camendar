import re

text = 'Job Expo 10AM - 3PM 1.12.2018 JOB OPPORTUNITIES AVAILABLE! We invite all employment and career resource centres, community centres, public service organizations and educational facilities from the Big Apple 21 your street  your city 1431 Call 012 345678 www.yourwebsite.com'
morning_time_matches = re.findall('\d+AM', text) or re.findall('\d + AM')
contact_matches= re.findall('\d+ \d+', text)

# Print the matches
print(contact_matches)


