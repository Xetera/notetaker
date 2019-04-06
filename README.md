# Notetaker
Taking notes in class with markdown but having troubles automating the process 
of sharing them with classmates? Here's how you do it.

## Usage
* Fork the repo.
* Setup [circle ci](https://circleci.com) on the project with the following environment variables.
  * **GDRIVE_DIR**: The base directory you want notetaker to upload the pdf files to.
  * **GDRIVE_REFRESH_TOKEN**: The google api refresh token.
* Get a google drive api refresh token from [here](https://developers.google.com/oauthplayground/).
* Push your notes to the `files` directory.
* Watch circle ci do its magic.

If you're not using circle ci, make sure to install `pandoc` and `gdrive` on the host machine.

this repo is still WIP
