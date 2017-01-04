from oauth2client.service_account import ServiceAccountCredentials
from httplib2 import Http

scopes = ['https://www.googleapis.com/auth/analytics.readonly']

credentials = ServiceAccountCredentials.from_json_keyfile_name(
    'keys/Viaa-key.json', scopes=scopes)

http_auth = credentials.authorize(Http())