require 'json'
require 'net/http'
require 'nokogiri'


namespace :web_scrapper do

  desc "Fetches course from MET RSS"
  task fetch_course: :environment do
    s = Net::HTTP.get_response(URI.parse('http://met.guc.edu.eg/Feeds/Course.ashx?c=508')).body
    s = s.split("").map(&:ord).select{ |x| x > 0 && x < 255 }.map(&:chr).join.gsub(/\r\n/,"\n").split("\n")[1..-1].join
    tmp = Nokogiri::XML s,nil, "UTF-8"
    puts JSON.pretty_generate(Hash.from_xml(tmp.to_xml)["rss"]["channel"]["item"].select{ |x| x["category"] == "Announcement" })

  end


  desc "Fetches all courses from MET RSS"
  task fetch_all_courses: :environment do
    s = Net::HTTP.get_response(URI.parse('http://met.guc.edu.eg/Feeds/RSS.aspx')).body
    s = s.split("").map(&:ord).select{ |x| x > 0 && x < 255 }.map(&:chr).join.gsub(/\r\n/,"\n").split("\n")[1..-1].join
    tmp = Nokogiri::XML s,nil, "UTF-8"
    courses = Hash.from_xml(tmp.to_xml)["html"]["head"]["link"]
    courses.each do |course|
      if course["type"] == "application/rss+xml"
        course_code = course["title"].split(":")[0]
        course_title = course["title"].split(":")[1].strip
        fetch_link = "http://met.guc.edu.eg/Feeds/" + course["href"]
        if Course.where(name: course_title, course_code: course_code).count == 0
          Course.create(name: course_title , course_code: course_code, description: "", fetch_link: fetch_link )
          puts "Created : " + course["title"]
        end
      end
    end
    #puts JSON.pretty_generate(courses)
  end

end
