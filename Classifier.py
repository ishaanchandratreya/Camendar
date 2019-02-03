from google.cloud import language as language
from google.cloud.language import enums
from google.cloud.language import types
import six



def classify_text(text):
    """Classifies content categories of the provided text."""
    client = language.LanguageServiceClient()

    if isinstance(text, six.binary_type):
        text = text.decode('utf-8')

    document = types.Document(
        content=text.encode('utf-8'),
        type=enums.Document.Type.PLAIN_TEXT)

    categories = client.classify_text(document).categories

    for category in categories:
        print(u'=' * 20)
        print(u'{:<16}: {}'.format('name', category.name))
        print(u'{:<16}: {}'.format('confidence', category.confidence))


classify_text('Movie review at Lerner Hall. Crime and Punishment by Fyodor Dostovsky. Free food but discuss about the book is mandatory')
#returns_"Arts and Entertainment/Film"
