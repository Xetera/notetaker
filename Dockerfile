FROM ubuntu

RUN apt-get update
RUN apt-get install pandoc
RUN curl "https://docs.google.com/uc?id=0B3X9GlR6EmbnQ0FtZmJJUXEyRTA&export=download" -o /usr/bin/gdrive