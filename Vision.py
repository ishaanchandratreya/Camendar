from google.cloud import vision
import io


def detect_text(path):
    """Detects text in the file."""
    from google.cloud import vision
    client = vision.ImageAnnotatorClient()

    with io.open(path, 'rb') as imageToRead:
        content = imageToRead.read()

    imageRead = vision.types.Image(content=content)

    response = client.text_detection(image=imageRead)
    event_description = response.text_annotations
    print('Texts:')

    for keyword in event_description:
        print('\n"{}"'.format(keyword.description))

        vertices = (['({},{})'.format(vertex.x, vertex.y)
                    for vertex in keyword.bounding_poly.vertices])

        print('bounds: {}'.format(','.join(vertices)))


detect_text('/Users/ishaanchandratreya/Desktop/Camendar/PythonCode/poster4.png')